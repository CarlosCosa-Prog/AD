package com.dam2;

import com.dam2.ch.Editorial;
import com.dam2.ch.Libro;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        //a- muestre las direcciones (sólo direcciones) de todas las editoriales.
        System.out.println("Dirección de todas las editoriales:");
        String s = "SELECT direccion FROM Editorial";
        Query q = ss.createQuery(s);
        List<String> l1 = q.getResultList();
        l1.forEach(System.out::println);

        //b- cuántos libros tiene cada editorial sin mostrar a la editorial
        System.out.println("\nCantidad de libros que tiene cada editorial sin mostrar la editorial:");
        s = "SELECT count(l) FROM Libros l, Editorial e WHERE e.isbn.id GROUP BY e.id";
        q = ss.createQuery(s);
        List<Long> l2 = q.getResultList();
        l2.forEach(System.out::println);


        //c- cuántos libros tiene cada editorial mostrando la editorial
        System.out.println("\nCantidad de libros que tiene cada editorial mostrando la editorial:");
        s = "SELECT count(l), e.nom FROM Libros l, Editorial e WHERE e.isbn.id GROUP BY e.id";
        q = ss.createQuery(s);
        Iterator it = q.getResultList().iterator();
        while (it.hasNext()) {
            Object array[] = (Object[]) it.next();
            System.out.println(array[1] + " tiene " + array[0] + " estos libro/s ");
        }


        //d- el libro "abc123" se lo asigno a la editorial con id 2
        System.out.println("\nAsignar libro 'abc123' a la editorial 2:");
        int editorialId = 2;
        Editorial e = ss.get(Editorial.class, editorialId);
        System.out.println("Se ha asignado el libro a la editorial: " + e);

        //e- borrar una editorial 3 (creada para la ocasión, no existía)
        System.out.println("\nBorrar editorial 3:");
        String hql = "DELETE FROM Editorial e where e.id = 3";
        Query q2 = ss.createQuery(hql);
        int result = q2.executeUpdate();
        System.out.println("El resultado ha sido: " + result + " (eliminado)");
        t.commit();

    }

}
