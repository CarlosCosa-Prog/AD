package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = new HibernateUtil().getSessionFactory();
        Session ss = sf.openSession();
        Transaction ts = ss.beginTransaction();
        Biografia biografia1 = new Biografia("Periodista famoso");
        Autor autor1 = new Autor("Tamayo",biografia1);
        // LAS BIOGRAFIAS NO TIENEN AUTOR
        Biografia biografia2 = new Biografia("Escritor español muy reconocido");
        Autor autor2 = new Autor("Miguel De Cervantes",biografia2);
        ContenidoDigital libro1 = new Libro("Don quijote",autor1,"834-31413-4");
        ss.persist(autor1);
        ss.persist(autor2);
        ts.commit();
        //Pregunta teoría
        /*
        Sirve para indicar si el programa estará en modo producción: validate o desarrollo:update
         */
    }
}
