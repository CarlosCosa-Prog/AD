package com.dam2;


import com.dam2.ch.Editorial;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class App2 {
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        //a- muestre las direcciones (sólo direcciones) de todas las editoriales.
        String s1 ="SELECT e.direccion FROM Editorial e";
        Query q1 = ss.createQuery(s1);
        List<String>l1 =q1.list();
        for(String s: l1){
            System.out.println("Direccion: " + s);
        }
        System.out.println();
        //b- cuántos libros tiene cada editorial sin mostrar a la editorial
        String s2 = "SELECT COUNT(l) FROM Editorial e, Libro l WHERE l.editorial.id = e.id GROUP BY e.id  ";
        Query q2 = ss.createQuery(s2);
        List<Long>l2 =q2.list();
        for(Long l: l2){
            System.out.println("Cantidad de libros " + l);
        }

        //c- cuántos libros tiene cada editorial mostrando la editorial
        String s3 ="SELECT COUNT(l) e.nom FROM Editorial e, Libro l WHERE l.editorial.id = e.id GROUP BY e.id  ";
        Query q3 = ss.createQuery(s3);
        Iterator it = q3.list().iterator();
        /*
        while(it.hasNext()){
            int c = (int)it.next();
            Editorial e = (Editorial)it.next();
            System.out.println("La editorial" + e.getNom() + " tiene" + c + " libros.");
        }*/


/*

        //d- el libro "abc123" se lo asigno a la editorial con id 2
        String s4 = "UPDATE e.libros FROM Editorial e, Libros l WHERE l.isbn = abc123";
        //Query q4 = ss.createQuery(s4);*/

        //e- borrar una editorial 3 (creada para la ocasión, no existía)
        String s5 = "DELETE FROM Editorial e WHERE e.id = 3";
        Query q6 = ss.createQuery(s5);

    }

}
