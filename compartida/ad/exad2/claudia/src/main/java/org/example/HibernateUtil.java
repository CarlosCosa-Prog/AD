package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory fs;

    public HibernateUtil() {}   // HA DE SER PRIVATE

    public static SessionFactory getSessionFactory() {
        if (fs == null) {
            fs = new Configuration().configure().buildSessionFactory();
        }
        return fs;
    }
}
