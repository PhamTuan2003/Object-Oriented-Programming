package com.vds.huylq33.service.impl;

import com.vds.huylq33.model.Account;
import com.vds.huylq33.model.User;
import com.vds.huylq33.service.UserService;
import com.vds.huylq33.utils.HibernateUtils;
import java.util.List;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * CRUD services for User A lot of boilerplate code for managing transaction (begin, commit,
 * rollback)
 */
public class UserServiceImpl implements UserService {

    private Transaction transaction;

    @Override
    public List<User> getAllUsers() {
        transaction = null;
        List<User> users = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            users = session.createQuery("From User", User.class).list();
            List<Account> accounts = session.createQuery("From Account", Account.class).list();
//            users.stream().map(User::getAddress).forEach(System.out::println);
            System.out.println(users.get(0).getAccounts());
            System.out.println(accounts);
            transaction.commit();
        } catch (Exception e) {
            rollBackTransaction(transaction);
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUser(int id) {
        transaction = null;
        User user = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            user = session.load(User.class, id);
            System.out.println(user.getAddress());

            transaction.commit();
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
            rollBackTransaction(transaction);
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.merge(user);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            rollBackTransaction(transaction);
        }
    }

    @Override
    public void updateUser(User user) {
        transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.merge(user);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            rollBackTransaction(transaction);
        }
    }

    @Override
    public void deleteUser(int id) {
        transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            rollBackTransaction(transaction);
        }
    }

    private void rollBackTransaction(Transaction transaction) {
        if (transaction != null) {
            transaction.rollback();
        }
    }
}
