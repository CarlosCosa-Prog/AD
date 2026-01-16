package org.pbo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private SessionFactory sf;

    public HibernateUtil() {}

    public SessionFactory getSf() { // HAZLO ESTÁTICO
        if  (sf == null) {
            sf = new Configuration().configure().buildSessionFactory();
        }
        return sf;
    }
}
