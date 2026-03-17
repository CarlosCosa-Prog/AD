package org.cosa;

import org.cosa.clases.Empleado;
import org.cosa.clases.Persona;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.getCurrentSession();
        Transaction t = s.beginTransaction();
        Persona p1 = new Persona("Carlos");
        Empleado emp1 = new Empleado("Antonio",2500);
        s.persist(p1);
        s.persist(emp1);
        t.commit();
    }
}
