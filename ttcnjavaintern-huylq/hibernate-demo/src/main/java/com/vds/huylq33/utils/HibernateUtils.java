package com.vds.huylq33.utils;

import com.vds.huylq33.model.Account;
import com.vds.huylq33.model.Address;
import com.vds.huylq33.model.Book;
import com.vds.huylq33.model.Cart;
import com.vds.huylq33.model.Product;
import com.vds.huylq33.model.User;
import java.util.Properties;
import java.util.function.Consumer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    private HibernateUtils() {
    }

    /**
     * Create SessionFactory using hibernate.cfg.xml
     * @return configured SessionFactory
     */
    /*public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (SessionFactory.class) {
                if (sessionFactory == null) {
                    try {
                        // Create registry
                        registry = new StandardServiceRegistryBuilder().configure().build();

                        // Create MetadataSources
                        MetadataSources sources = new MetadataSources(registry);

                        // Create Metadata
                        Metadata metadata = sources.getMetadataBuilder().build();

                        // Create SessionFactory
                        sessionFactory = metadata.getSessionFactoryBuilder().build();
                    } catch (Exception e) {
                        e.printStackTrace();
                        shutdown();
                    }
                }
            }
        }
        return sessionFactory;
    }*/

    /**
     * Create SessionFactory using Java-based configuration
     *
     * @return configured SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (HibernateUtils.class) {
                if (sessionFactory == null) {
                    try {
                        Configuration configuration = new Configuration();

                        // Hibernate settings equivalent to hibernate.cfg.xml properties
                        Properties settings = new Properties();
                        settings.put(Environment.DRIVER, "org.h2.Driver");
                        settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
                        settings.put(Environment.URL, "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
                        settings.put(Environment.USER, "sa");
                        settings.put(Environment.PASS, "");

                        settings.put(Environment.SHOW_SQL, true);

                        settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                        configuration.setProperties(settings);
                        configuration.addAnnotatedClass(Account.class);
                        configuration.addAnnotatedClass(Address.class);
                        configuration.addAnnotatedClass(User.class);
                        // Projections demo classes
                        configuration.addAnnotatedClass(Product.class);
                        configuration.addAnnotatedClass(Cart.class);
                        // Operations demo classes
                        configuration.addAnnotatedClass(Book.class);

                        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties()).build();

                        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                    } catch (Exception e) {
                        e.printStackTrace();
                        shutdown();
                    }
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static void doTransaction(Consumer<Session> consumer) {
        Transaction transaction = null;
        try (Session session = getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            consumer.accept(session);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
