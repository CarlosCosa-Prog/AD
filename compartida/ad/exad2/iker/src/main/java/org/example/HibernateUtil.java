package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    //CREAMOS LA SESION ESTATICA PARA LA PARTE DE LA APP.
    public static SessionFactory sf;

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        if (null == sf) {
            sf = new Configuration().configure().buildSessionFactory();
        }
        return sf;
    }
}
