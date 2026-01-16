package com.dam2;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sf;
    // necesario para que el compilador no lo haga public
    private HibernateUtil() {

    }
    public static SessionFactory getSessionFactory() {
        if (sf == null) {
            // Confiuration() tiene que ser el de org.hibernate.cfg
            sf = new Configuration().configure().
                    buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        }
        return sf;
    }
}
