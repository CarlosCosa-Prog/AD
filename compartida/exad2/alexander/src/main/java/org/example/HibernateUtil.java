package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory factory; // Creamos el session factory

    // Constructor general
    public HibernateUtil() {    // HA DE SER PRIVADO
    }

    // Método getSessionFactory
    public static SessionFactory getSessionFactory(){
        if(factory == null){ // Si es null entonces construir un SessionFactory
            factory = new Configuration().configure().buildSessionFactory();
        }
        return factory; // En caso contrario devolvemos la sessión ya cr
    }
}
