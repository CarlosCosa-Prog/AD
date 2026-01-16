package com.dam2.ejercicio1;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory sf;
    private HibernateUtil()
    {}
    public static SessionFactory getSessionFactory()
    {
        if (sf == null)
            sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        return sf;
    }
}
