package org.cosa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tr = session.beginTransaction();

        Empleado empleado = new Empleado("Carlos", 2000);
        session.save(empleado);
        tr.commit();

    }
}
