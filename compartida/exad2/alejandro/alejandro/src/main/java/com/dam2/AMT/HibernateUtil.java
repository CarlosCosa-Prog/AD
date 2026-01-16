package com.dam2.AMT;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory sf;

    private static HibernateUtil(){ // EL CONSTRUCTOR NO PUEDE SER ESTÁTICO

    }

    public static SessionFactory getSessionFactory() {
        // SÓLO SI SF ERA NULL
        sf = new Configuration().configure().buildSessionFactory();
        return sf;
    }


}
