package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf =HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Libro libro = new Libro();
        libro.setTitulo("Titulo 1");


        session.save(libro);
        session.close();
        tx.commit();
    }

    /**
     * ACT2
     *
     * Las diferentes opciones de hbm2ddl son el <property name="hibernate.hbm2ddl.auto">update</property> que la usaremos mientras trabajamos
     * y estamos haciendo pruebas por asi decirlo,y posteriormente cuando ya funcione se ejecutara la property name validate que es:
     * <property name="hibernate.hbm2ddl.auto">validate</property> Esta la haremos cuando ya tengamos el trabajo y codigo pulido por asi decirlo,la version final
     */
}
