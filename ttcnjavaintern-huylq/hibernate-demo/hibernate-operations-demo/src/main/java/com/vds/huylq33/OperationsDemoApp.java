package com.vds.huylq33;

import static com.vds.huylq33.utils.HibernateUtils.doTransaction;
import static com.vds.huylq33.utils.HibernateUtils.getSessionFactory;

import com.vds.huylq33.model.Book;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;

public class OperationsDemoApp {

    private static final Logger logger = Logger.getLogger(OperationsDemoApp.class.getName());

    public static void main(String[] args) {
//        persistDemo();
        saveDemo();
//        updateDemo();
//        nonUniqueObjectExceptionDemo();
//        mergeDemo();
//        mergeWithAssignedGeneratorDemo();
    }

    private static void persistDemo() {
        doTransaction(session -> {
            Book book = new Book();
            book.setName("Sapiens");

            // Insert would be postponed until flush is called
            // EXCEPT: id using IDENTITY strategy will trigger insert immediately
            // Because sql query needs to be executed in order to get id
            session.persist(book);
            logger.info("Persisting Book entity");
        });
    }

    private static void saveDemo() {
        Book book = new Book();
        doTransaction(session -> {
            book.setName("Sapiens");
            // Save method returns entity identifier, persist doesnt
            Integer entityIdentifier = (Integer) session.save(book);
            logger.info("Saving Book entity");
        });

        // Insert another book
        doTransaction(session -> {
            session.save(book);
        });

        // Two books in DB
        doTransaction(session -> {
            List<Book> books = session.createQuery("FROM Book", Book.class).list();
            books.forEach(System.out::println);
        });
    }

    private static void updateDemo() {
        Book book = new Book();
        book.setName("Sapiens");
        doTransaction(session -> {
            session.persist(book);
            // Multiple sets only perform one update sql
            book.setTitle("Homo");
            book.setAuthor("Hakari");
            book.setTitle("Homo Sapiens");
        });

        logger.info("Modifying Book entity");
        book.setAuthor("Akira");

        doTransaction(session -> {
            session.update(book);
            logger.info("Updating Book entity");
        });
    }

    private static void nonUniqueObjectExceptionDemo() {
        Book book = new Book();
        book.setName("Sapiens");
        doTransaction(session -> {
            session.saveOrUpdate(book);
        });

        book.setAuthor("Akira");

        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            Book bookInDB = session.get(Book.class, book.getId());
            session.saveOrUpdate(book);
            session.getTransaction().commit();
        } catch (NonUniqueObjectException e) {
            logger.log(Level.SEVERE, "Session cannot hold 2 representations of the same entity");
        }
    }

    private static void mergeDemo() {
        Book book = new Book();
        book.setName("Sapiens");

        doTransaction(session -> {
            Book persistentBook = (Book) session.merge(book);
            session.merge(book);
            persistentBook.setName("Homo Sapiens");
            session.merge(persistentBook);
        });

        book.setAuthor("Akira");

        try (Session session = getSessionFactory().openSession()) {
            session.beginTransaction();
            Book persistentBook = (Book) session.merge(book);
            logger.info("Merging Book entity");
            session.getTransaction().commit();
        } catch (NonUniqueObjectException e) {
            logger.log(Level.SEVERE, "Session cannot hold 2 representations of the same entity");
        }
    }

    private static void mergeWithAssignedGeneratorDemo() {
        doTransaction(session -> {
            Book book = new Book();
            book.setId(1);
            book.setName("Sapiens");
            // Will select first and then insert (assign strategy)
            session.merge(book);
        });
    }
}
