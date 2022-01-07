package com.bankchallenge.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    private static Configuration configurantion;

    /**
     *
     */
    public static SessionFactory getSessionFactory() {
        try {
            configurantion = new Configuration().configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(configurantion.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();
            sessionFactory = configurantion.buildSessionFactory(standardServiceRegistry);
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed" + e);
            throw new ExceptionInInitializerError(e);
        }

        return sessionFactory;
    }
}
