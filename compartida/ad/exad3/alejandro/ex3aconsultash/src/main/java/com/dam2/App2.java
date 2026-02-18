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
        System.out.println("Direcciones");
        String s = "select e.direccion FROM Editorial e";
        Query q = ss.createQuery(s);
        List<String> editoriales = q.list();
        editoriales.forEach(System.out::println);

        //b- cuántos libros tiene cada editorial sin mostrar a la editorial
        System.out.println("cuántos libros tiene cada editorial sin mostrar a la editorial");
        s = "Select count(l) FROM Libro l, Editorial e WHERE l.editorial = e group by e.id";
        Query<Long> q2 = ss.createQuery(s, Long.class);
        List<Long> conteo = q2.list();
        conteo.forEach(System.out::println);

        //c- cuántos libros tiene cada editorial mostrando la editorial
        //s = "Select count(l) FROM Libro l, Editorial e WHERE l.editorial = e.id order by e.id";

        //d- el libro "abc123" se lo asigno a la editorial con id 2


        //e- borrar una editorial 3 (creada para la ocasión, no existía)
        System.out.println("borrar una editorial 3");
        String HQL = "DELETE FROM Editorial WHERE id = 3";
        Query q1 = ss.createQuery(HQL);
        int result = q1.executeUpdate();
        System.out.println("lineas afectadas : " + result);


    }

}
