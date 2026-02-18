package com.dam2;

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

        String hql;
        Query query;

        //a- muestre las direcciones (sólo direcciones) de todas las editoriales.
        System.out.println("Muestre las direcciones (sólo direcciones) de todas las editoriales.");
        hql = "Select direccion from Editorial";
        query = ss.createQuery(hql);
        List<String> l1 = query.list();
        l1.forEach(System.out::println);

        //b- cuántos libros tiene cada editorial sin mostrar a la editorial
        System.out.println("\nCuántos libros tiene cada editorial sin mostrar a la editorial");
        hql = "Select count(l) from Libro l group by l.editorial.nom";
        query = ss.createQuery(hql);
        List<Long> l2 = query.list();
        l2.forEach(System.out::println);

        //c- cuántos libros tiene cada editorial mostrando la editorial
        System.out.println("\nCuántos libros tiene cada editorial mostrando la editorial");
        hql = "Select count(l), e.nom from Editorial e, Libro l where e.id = l.editorial.id group by e.nom";
        query = ss.createQuery(hql);
        Iterator it = query.stream().iterator();
        while (it.hasNext()) {
            Object[] o = (Object[]) it.next();
            System.out.println("La editorial " + o[1] + " tiene " + o[0] + " libro/s");
        }

        //d- el libro "abc123" se lo asigno a la editorial con id 2
        System.out.println("\nEl libro \"abc123\" se lo asigno a la editorial con id 2");
        hql = "Update Libro l set l.editorial.id = 2 where l.isbn = 'abc123'";
        query = ss.createQuery(hql);
        int result = query.executeUpdate();
        System.out.println("Filas actualizadas: " + result);

        //e- borrar una editorial 3 (creada para la ocasión, no existía) NO ES EL 3
        System.out.println("\nBorrar una editorial 3 (creada para la ocasión, no existía)");
        hql = "Insert into Editorial(id,nom, direccion)" +
        "Select 50L,'Ed1', 'C/Inventada 2'";
        query = ss.createQuery(hql);
        result = query.executeUpdate();
        System.out.println("Filas creadas: " + result);

        hql = "Delete from Editorial where id = 50";
        query = ss.createQuery(hql);
        result = query.executeUpdate();
        System.out.println("Filas eliminadas: " + result);

        t.commit();

    }

}
