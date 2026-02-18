package com.dam2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class App2 {
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        //a- muestre las direcciones (sólo direcciones) de todas las editoriales.
        String s = "select e.direccion from Editorial e";
        Query<String> q1 = ss.createQuery(s, String.class);
        List<String> direcciones = q1.getResultList();
        direcciones.forEach(System.out::println);

        //b- cuántos libros tiene cada editorial sin mostrar a la editorial
        s = "select count(l) from Editorial e";
        Query<Long> q2 = ss.createQuery(s, Long.class);
        List<Long> libros = q2.getResultList();
        libros.forEach(System.out::println);

        //c- cuántos libros tiene cada editorial mostrando la editorial

        //d- el libro "abc123" se lo asigno a la editorial con id 2

        //e- borrar una editorial 3 (creada para la ocasión, no existía)

    }

}
