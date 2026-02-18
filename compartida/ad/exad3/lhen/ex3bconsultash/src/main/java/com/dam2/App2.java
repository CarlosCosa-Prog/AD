package com.dam2;

import com.dam2.ch.Discografica;
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

        // 	a- muestre las direcciones (sólo direcciones) de todas las discográficas.
        System.out.println("\na- muestre las direcciones (sólo direcciones) de todas las discográficas.");
        String s = "SELECT d.direccion FROM Discografica d";
        Query<String> q = ss.createQuery(s, String.class);
        List<String> l1 = q.getResultList();
        l1.forEach(System.out::println);

        // b- cuántos discos tiene cada discográfica sin mostrar la discográfica
        System.out.println("\nb- cuántos discos tiene cada discográfica sin mostrar la discográfica");
        s = "SELECT count(d) from Disco d, Discografica dg WHERE d.discografica.id = dg.id group by d.discografica.id";
        Query<Long> q2 = ss.createQuery(s, Long.class);
        List<Long> l2 = q2.getResultList();
        l2.forEach(System.out::println);

        // c- cuántos discos tiene cada discográfica mostrando la discográfica
        System.out.println("\nc- cuántos discos tiene cada discográfica mostrando la discográfica");
        s = "SELECT count(d), dg.nom from Disco d, Discografica dg WHERE d.discografica.id = dg.id group by dg.id";
        Query<Object[]> q3 = ss.createQuery(s, Object[].class);
        Iterator it = q3.stream().iterator();
        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            System.out.println(obj[1] + " tiene " + obj[0] + " discos.");
        }

        // d- el disco "xyz987" se lo asigno a la editorial con id 2
        System.out.println("\nd- el disco \"xyz987\" se lo asigno a la editorial con id 2");
        s = "UPDATE Disco d SET d.discografica.id = 2L WHERE d.isrc = 'xyz987'";
        Query q4 = ss.createQuery(s);
        int res = q4.executeUpdate();
        System.out.println("Líneas actualizadas: " + res);

        // e- borrar una discográfica 3 (creada para la ocasión, no existía)
        System.out.println("\ne- borrar una discográfica 3 (creada para la ocasión, no existía)");
        Discografica d = new Discografica();
        d.setId(3L);
        s = "DELETE FROM Discografica d WHERE d.id = 3";
        Query q5 = ss.createQuery(s);
        res = q5.executeUpdate();
        System.out.println("Líneas eliminadas: " + res);

        t.commit();
    }

}
