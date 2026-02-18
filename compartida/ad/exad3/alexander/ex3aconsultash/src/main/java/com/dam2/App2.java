package com.dam2;

import com.dam2.ch.Editorial;
import com.dam2.ch.Libro;
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
        System.out.println("\nCONSUTLTA A:");

        String queryAddress = "SELECT e.direccion FROM Editorial e";                    // Creamos la cadena a utilizar para la consulta
        List<String> address = ss.createQuery(queryAddress, String.class).list();       // Creamos la consulta
        address.forEach(System.out::println);                                           // Usando un forEach imprimimos la consulta por terminal

        //b- cuántos libros tiene cada editorial sin mostrar a la editorial
        System.out.println("\nCONSUTLTA B:");

        String queryBooks = "SELECT COUNT(l) FROM Libro l GROUP BY l.editorial";        // Creamos la cadena a utilizar para la consulta
        List<Long> books = ss.createQuery(queryBooks, Long.class).list();               // Creamos la consulta
        books.forEach(System.out::println);                                             // Usando un forEach imprimimos la consulta por terminal

        //c- cuántos libros tiene cada editorial mostrando la editorial
        System.out.println("\nCONSUTLTA C:");

        String queryBooks2 = "SELECT e.nom, count(l) FROM Editorial e, Libro l " +
                "WHERE e.id = l.editorial.id " +
                "GROUP BY e.id";     // Creamos la cadena a utilizar para la consulta

        // Creamos la query
        Query books2 = ss.createQuery(queryBooks2);

        // Creamos un iterator
        Iterator it = books2.stream().iterator();

        // Realizamos bucle while
        while (it.hasNext()) {
            // Realizamos casting a objeto del iterator
            Object[] data =  (Object[]) it.next();
            String editorial = (String) data[0];
            Long cantBooks = (Long) data[1];
            System.out.println("La editorial " + editorial + " tiene " + cantBooks);
        }

        //d- el libro "abc123" se lo asigno a la editorial con id 2
        System.out.println("\nCONSUTLTA D:");

        String updateOp2 = "UPDATE Libro l SET l.editorial.id = :idED WHERE l.isbn = :isbnBk";
        Query upQuery = ss.createQuery(updateOp2);
        upQuery.setParameter("idED", 2);
        upQuery.setParameter("isbnBk", "abc123");
        int resUp = upQuery.executeUpdate();
        System.out.println("Filas actualizadas: " + resUp);

        //e- borrar una editorial 3 (creada para la ocasión, no existía)
        System.out.println("\nCONSUTLTA E:");
        String delOp = "DELETE FROM Editorial e WHERE e.id = :idED";
        Query  delQuery = ss.createQuery(delOp);
        delQuery.setParameter("idED", 3);
        int resDel = delQuery.executeUpdate();
        System.out.println("Filas eliminadas: " + resDel);

        t.commit();
    }

}
