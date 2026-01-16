package org.examenoscar;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory sf;

    private HibernateUtil(){
    }
    public static SessionFactory getSessionFactory(){
        if (sf == null){
            sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return sf;
    }

}
