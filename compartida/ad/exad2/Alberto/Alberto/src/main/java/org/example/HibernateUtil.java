package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    public static SessionFactory sf;
    // FALTA CONSTRUCTOR PRIVADO
    public static Session getSession() {
        if (sf == null) {
            sf = new Configuration().configure().buildSessionFactory();
        }
        return (Session) sf;    // NO MOLDEES, HA DE SER SF
    }


}
