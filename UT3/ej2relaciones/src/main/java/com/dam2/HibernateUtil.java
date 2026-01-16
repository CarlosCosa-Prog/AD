package com.dam2;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sf;

    // 2. HibernateUtil sin parámetros para que nadie pueda hacer (new HibernateUtil)
    private HibernateUtil() {}

    //
    public static SessionFactory getSessionFactory() {
        if (null == sf) // todavía no se ha creado
            // IMPORTANTE: EL import de Configuration tiene que ser el de hibernate
            sf = new Configuration().configure().
                    buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        return sf;
    }

}
