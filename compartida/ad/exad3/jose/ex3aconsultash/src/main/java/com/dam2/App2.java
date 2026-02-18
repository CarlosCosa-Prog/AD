package com.dam2;

import com.dam2.ch.Editorial;
import com.dam2.ch.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;


public class App2 {
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        //a- muestre las direcciones (sólo direcciones) de todas las editoriales.
        String s1 = "SELECT e.direccion from Editorial e";
        Query q1 = ss.createQuery(s1);
        List<String> editoriales = q1.getResultList();
        for (String editorial : editoriales) {System.out.println(editorial);}


        //b- cuántos libros tiene cada editorial sin mostrar a la editorial
        String s2 = "SELECT COUNT(l) from Editorial e, Libro l WHERE e.id = l.editorial.id GROUP BY l.editorial.id";
        Query<Long> q2 = ss.createQuery(s2, Long.class);
        List<Long> e2 = q2.getResultList();
        e2.forEach(System.out::println);



        //c- cuántos libros tiene cada editorial mostrando la editorial
        String s3 = "SELECT COUNT(l), e.nom from Editorial e, Libro l WHERE e.id = l.editorial.id GROUP BY e.nom";
        Query<Object[]> q3 = ss.createQuery(s3, Object[].class);
        Iterator it = q3.stream().iterator();
        while (it.hasNext()) {
            Object[] array = (Object[]) it.next();
            System.out.println("La editorial "+array[1] + " tiene x libros: " + array[0]);
        }



       //d- el libro "abc123" se lo asigno a la editorial con id 2
        String s4 = "UPDATE Libro l SET l.editorial.id = 2 WHERE l.isbn='abc123'";
        Query q4 = ss.createQuery(s4);
        int sol = q4.executeUpdate();
        System.out.println("Cambios en linea:" + sol);

        //e- borrar una editorial 3 (creada para la ocasión, no existía)
        String s5 = "DELETE FROM Editorial e WHERE e.id = :num";
        Query q5 = ss.createQuery(s5);
        q5.setParameter("num", 3);
        sol = q5.executeUpdate();
        System.out.println("linea borrada: "+sol);

        t.commit();
    }

}
