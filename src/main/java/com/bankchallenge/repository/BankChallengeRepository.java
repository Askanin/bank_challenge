package com.bankchallenge.repository;


import com.bankchallenge.config.HibernateUtils;
import com.bankchallenge.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BankChallengeRepository {

    public static void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
