package com.dam2;

import com.dam2.ch.Editorial;
import com.dam2.ch.Libro;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class App2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();


        //a- muestre las direcciones (sólo direcciones) de todas las editoriales.
        String s = "select direccion from Editorial";
        Query q1 = session.createQuery(s);
        List<String> direcciones = q1.getResultList();
        direcciones.forEach(System.out::println);


        //b- cuántos libros tiene cada editorial sin mostrar a la editorial
        s = "select count(l) from Editoral e, Libro l where e.id = l.editorial group by e.id";
        Query q2 = session.createQuery(s);
        List<Long> libros = q2.getResultList();
        libros.forEach(System.out::println);

        //c- cuántos libros tiene cada editorial mostrando la editorial
        s = "select count(l), e.nom from Editoral e, Libro l where e.id = l.id group by l.id";
        Query q3 = session.createQuery(s);
        Iterator it = q3.getResultStream().iterator();
        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            System.out.println(obj[0] + " tiene " + obj[1] + " libros " + obj[2]);

        }


        //d- el libro "abc123" se lo asigno a la editorial con id 2
        s = "select l from Libro l, Editorial e where l.isbn = :isbn and e.id = :id";
        Query q4 = session.createQuery(s);
        q4.setParameter("isbn", "abc123");
        q4.setParameter("id", 3);
        List<Libro> libros2 = q4.getResultList();
        libros2.forEach(System.out::println);


        //e- borrar una editorial 3 (creada para la ocasión, no existía)
        s = "DELETE Editorial e where e.id = :id";
        Query q5 = session.createQuery(s);
        q5.setParameter("id", 3);
        int result = q5.executeUpdate();
        System.out.println("Filas afectadas: " + result);
    }

}
