package com.boots.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//мусор
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory;
        if (sessionFactory == null) {
            synchronized (SessionFactory.class) {
                sessionFactory = HibernateUtil.sessionFactory;
                if (sessionFactory == null) {
                    Configuration configuration = new Configuration();
                    configuration.configure("hibernate.cfg.xml");
                    sessionFactory = configuration.buildSessionFactory();
                    HibernateUtil.sessionFactory = sessionFactory;
                }
            }
        }
        return sessionFactory;
    }
}