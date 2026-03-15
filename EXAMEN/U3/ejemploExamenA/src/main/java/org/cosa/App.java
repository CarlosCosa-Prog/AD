package org.cosa;

import org.cosa.clases.Propietario;
import org.hibernate.*;

public class App
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.getCurrentSession();
        Transaction tr = ss.beginTransaction();

        Propietario p1 = new Propietario("Juan");
        ss.persist(p1);
        
    }
}
