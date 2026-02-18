package com.dam2;

import com.dam2.ch.Discografica;
import com.dam2.ch.Disco;
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

        Discografica dg1 = new Discografica("CBS","c/ Del pez, 23");
        Disco d1 = new Disco("xyz987", dg1);
        dg1.getDiscos().add(d1);

        Disco d2 = new Disco("wxy654", dg1);
        dg1.getDiscos().add(d2);

        Discografica dg2 = new Discografica("Universal","c/ La fuente, 46");
        Disco d3 = new Disco("cde345", dg2);
        dg2.getDiscos().add(d3);

        ss.persist(dg1);
        ss.persist(dg2);
        t.commit();
    }
}