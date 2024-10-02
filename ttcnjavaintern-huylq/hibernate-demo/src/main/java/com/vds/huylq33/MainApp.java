package com.vds.huylq33;

import com.vds.huylq33.model.Account;
import com.vds.huylq33.model.Address;
import com.vds.huylq33.model.User;
import com.vds.huylq33.service.UserService;
import com.vds.huylq33.service.impl.UserServiceImpl;
import com.vds.huylq33.utils.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {

    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        initDatabase();
        List<User> users = userService.getAllUsers();
//        users.forEach(System.out::println);
//
//        System.out.println();
//        System.out.println("================= FIRST LEVEL CACHING ========================");
//        System.out.println();
//
//        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
//            session.beginTransaction();
//
//            System.out.println(session.load(User.class, 1).getName());
//            System.out.println(session.load(User.class, 1).getName());
//
//            System.out.println("===== Clear =====");
//            session.clear();
//
//            System.out.println(session.load(User.class, 1).getName());
//            System.out.println(session.load(User.class, 1).getName());
//
//            System.out.println("===== Evict =====");
//            session.evict(session.load(User.class, 1));
//
//            System.out.println(session.load(User.class, 1).getName());
//            System.out.println(session.load(User.class, 1).getName());
//
//            session.getTransaction().commit();
//        }
    }

    public static void initDatabase() {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Address address1 = new Address("Hà Nội", "Hồ Tùng Mậu", "1000");
            Address address2 = new Address("Biên Hòa", "Long Bình", "2000");

            Account account1 = new Account("admin", "admin");
            Account account2 = new Account("user", "user");
            Account account3 = new Account("sale", "sale");

            User user1 = new User("huylq", address1);
            User user2 = new User("thomasle", address2);
            user1.addAccount(account1, account2);
            user2.addAccount(account3);

            session.save(user1);
            session.save(user2);
//            user1.setName("huylq33");
//            user1.getAddress().setStreet("Nam Từ Liêm");
//            session.flush();

//            session.refresh(user1);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
