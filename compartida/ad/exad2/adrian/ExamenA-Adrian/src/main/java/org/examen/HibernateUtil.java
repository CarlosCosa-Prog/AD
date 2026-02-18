package org.examen;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {
    protected static SessionFactory sf;

    HibernateUtil() {}  // HA DE SER PRIVADO

    public static SessionFactory getsf() {  // Y ESTE PUBLIC
        if (sf == null) {
            sf = new Configuration().configure().buildSessionFactory(new
            StandardServiceRegistryBuilder().configure().build());
        }
        return sf;
    }


}
