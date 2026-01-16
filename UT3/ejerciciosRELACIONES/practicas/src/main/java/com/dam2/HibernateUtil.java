package com.dam2;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private SessionFactory sessionFactory;
    private HibernateUtil() {}
    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory =new Configuration().configure().
                    buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        }
        return sessionFactory;
    }
}
