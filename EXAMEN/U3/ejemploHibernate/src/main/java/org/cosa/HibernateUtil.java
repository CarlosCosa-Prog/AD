package org.cosa;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sf;

    // private para deshabilitar la creación de otros objetos desde otras clases
    private HibernateUtil() {}

    // crear una sola instancia (singleton)
    public static SessionFactory getSessionFactory() {
        if (sf == null) {
            sf = new Configuration().configure().   // carga el hibernate.cfg.xml
                    buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        }
        return sf;
    }
}
