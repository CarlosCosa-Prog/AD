package com.dam2;

import com.dam2.ch.Editorial;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class App2 {
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();


        //a- muestre las direcciones (sólo direcciones) de todas las editoriales.
        String sa = "SELECT e.direccion FROM Editorial e";

        Query q1 = ss.createQuery(sa, String.class);
        List<String> listaEditorial = q1.getResultList();

        System.out.println("A) --Lista de direcciones de editoriales--");

        for (String s : listaEditorial) {
            System.out.println("Direccion : " + s);
        }

        //b- cuántos libros tiene cada editorial sin mostrar a la editorial

        String sb ="select count(e.libros) from Editorial e";

        Query q2 = ss.createQuery(sb,Long.class);
        List<Long> ListaLibros =(List<Long>) q2.getResultList();

        System.out.println("\nB) --Numero de libros--");
        for (Long l : ListaLibros) {
            System.out.println("Numero de libros : " + l);
        }


        //c- cuántos libros tiene cada editorial mostrando la editorial

        //d- el libro "abc123" se lo asigno a la editorial con id 2

        String sd="update Editorial e set e.libro = :lib where id = :id";

        Query q4 = ss.createQuery(sd);
        q4.setParameter("libro", "abc123");
        q4.setParameter("id", 2);
        q4.executeUpdate();
        t.commit();

        //e- borrar una editorial 3 (creada para la ocasión, no existía)

    }

}
