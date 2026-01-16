package com.dam2;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory factory;
    // para deshabilitar la creación de otros objetos desde otras clases
    private HibernateUtil() {
    }
    // nos aseguramos de crear una sola instancia (singleton)
    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration().configure("hibernate.cfg.xml").
                    buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        }
        return factory;
    }
}
