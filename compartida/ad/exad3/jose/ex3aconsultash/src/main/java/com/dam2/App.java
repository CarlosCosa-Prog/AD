package com.dam2;

import com.dam2.ch.Editorial;
import com.dam2.ch.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        Editorial ed1 = new Editorial("McMillan Hill","c/ Pablo Iglesias, 23");
        Libro l1 = new Libro("abc123", ed1);
        ed1.getLibros().add(l1);

        Libro l2 = new Libro("bcd234", ed1);
        ed1.getLibros().add(l2);

        Editorial ed2 = new Editorial("Bran-ca","c/ Joan Fuster, 46");
        Libro l3 = new Libro("cde345", ed2);
        ed2.getLibros().add(l3);

        ss.persist(ed1);
        ss.persist(ed2);
        t.commit();
    }
}