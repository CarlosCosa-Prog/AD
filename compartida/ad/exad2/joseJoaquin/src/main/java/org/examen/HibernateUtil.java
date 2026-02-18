package org.examen;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static HibernateUtil hiber; // NO, TOTALMENTE INNECESARIO

    private SessionFactory SF;

    public SessionFactory getSessionFactory() {
        return SF;
    }

    public static HibernateUtil getInstance() {
        if (hiber == null) {
            hiber = new HibernateUtil();
        }
        return hiber;
    }

    private HibernateUtil() {   // AL SER EL CONSTRUCTOR ES PRIVADO NO TIENE SENTIDO SU CÓDIGO
        try {
            SF = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }


}


