package com.dam2;

import com.dam2.relaciones.Autor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //SessionFactory sf = HibernateUtil.getSessionFactory();
        Autor autor1 = new Autor();
        session.save(autor1);
        session.getTransaction().commit();

        autor1.setNombre("Autor1");

    }

}
