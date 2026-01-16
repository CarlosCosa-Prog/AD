package org.pcg;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public SessionFactory sf;
    private HibernateUtil(){}

    public SessionFactory getSessionFactory() { // HA DE SER STATIC
        if (sf == null) {
            sf = new Configuration().configure().buildSessionFactory();
        }
        return sf;
    }
}
