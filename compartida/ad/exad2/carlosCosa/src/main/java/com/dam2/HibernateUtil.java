package com.dam2;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    HibernateUtil() {}  // PRIVADO
    private static SessionFactory ssf;

    public static SessionFactory getSessionFactory() {
        if (ssf == null) {
            ssf = new Configuration().configure().buildSessionFactory();
        }
        return ssf;
    }
}
