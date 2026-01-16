package com.dam2;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sf;
    // tiene que ser private para cumplir con el patrón Singleton
    private HibernateUtil() {}
    public static SessionFactory getSessionFactory() {
        if (sf == null) {
            sf = new Configuration().configure().buildSessionFactory();
        }
        return sf;
    }
}
