package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private SessionFactory sf;

    public HibernateUtil() {    // HA DE SER PRIVADO
    }
    public SessionFactory getSessionFactory() {
        if (sf == null) {
            sf = new Configuration().configure().buildSessionFactory();
        }
        return sf;
    }
}
