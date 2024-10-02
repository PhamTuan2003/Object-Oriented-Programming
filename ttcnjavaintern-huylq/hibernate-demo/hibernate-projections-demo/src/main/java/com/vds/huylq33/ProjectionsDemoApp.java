package com.vds.huylq33;

import static com.vds.huylq33.utils.HibernateUtils.doTransaction;

import com.vds.huylq33.model.Cart;
import com.vds.huylq33.model.Product;
import com.vds.huylq33.utils.HibernateUtils;
import java.util.Arrays;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

public class ProjectionsDemoApp {

    public static void main(String[] args) {
        initDB();
//        List<String> productNames = selectOnlyProductName();
//        List<Object[]> productNamesAndPrices = selectProductInfo();
        List<Object[]> totalProductPrices = calTotalPrices();

        totalProductPrices.forEach(obj -> System.out.println(Arrays.asList(obj)));
    }

    private static void initDB() {
        doTransaction(session -> {
            Product product1 = new Product("Redmi Note 4", 4_500_000D, "Hàng Tàu nhập lậu");
            Product product2 = new Product("Dell", 10_500_000D, "Hàng chợ giá rẻ");
            Product product3 = new Product("Dép Lào", 500_000D, "Hàng Đức chất lượng cao");

            session.persist(product1);
            session.persist(product2);
            session.persist(product2);
            session.persist(product3);
            session.persist(product3);

            Cart cart = new Cart();
            cart.addProduct(product1, product2);

            session.persist(cart);
        });
    }

    private static List<String> selectOnlyProductName() {
        List<String> resultList;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<String> query = builder.createQuery(String.class);
            Root<Product> root = query.from(Product.class);
            query.select(root.get("name"));
            resultList = session.createQuery(query).getResultList();
            session.getTransaction().commit();
        }
        return resultList;
    }

    private static List<Object[]> selectProductInfo() {
        List<Object[]> resultList;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
            Root<Product> root = query.from(Product.class);
            query.multiselect(root.get("id"), root.get("name"), root.get("price"));
            resultList = session.createQuery(query).getResultList();

            session.getTransaction().commit();
        }
        return resultList;
    }

    private static List<Object[]> calTotalPrices() {
        List<Object[]> resultList;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
            Root<Product> root = query.from(Product.class);
            query.multiselect(root.get("name"), builder.sum(root.get("price")));
            query.groupBy(root.get("name"));
            resultList = session.createQuery(query).getResultList();
            session.getTransaction().commit();
        }
        return resultList;
    }
}
