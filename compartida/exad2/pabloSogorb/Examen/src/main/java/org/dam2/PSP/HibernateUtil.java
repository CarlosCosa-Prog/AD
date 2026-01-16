package org.dam2.PSP;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory sf;

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sf == null) {
            sf = new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        }
        return sf;
    }
}
