package com.dam2;

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
        Transaction tx = ss.beginTransaction();

        // 	a- muestre las direcciones (sólo direcciones) de todas las discográficas.
        System.out.println("a- muestre las direcciones (sólo direcciones) de todas las discográficas.");
        String s = "select df.direccion from Discografica df";
        Query q = ss.createQuery(s);
        List l = q.getResultList();
        l.forEach(System.out::println);

        // b- cuántos discos tiene cada discográfica sin mostrar la discográfica
        System.out.println("b- cuántos discos tiene cada discográfica sin mostrar la discográfica");
        s = "select count(di) from Disco di group by di.discografica.id";
        q = ss.createQuery(s);
        l = q.getResultList();
        l.forEach(System.out::println);

        // c- cuántos discos tiene cada discográfica mostrando la discográfica
        /*
        System.out.println("c- cuántos discos tiene cada discográfica mostrando la discográfica");
        s = "select count(di), df.nom from Discografica df, Disco di where df.id=di.discografica.id  group by di.discografica.id";
        q = ss.createQuery(s);
        Iterator it = q.stream.iterator()

        // d- el disco "xyz987" se lo asigno a la editorial con id 2
        System.out.println("d- el disco xyz987 se lo asigno a la editorial con id 2");
        s = "update Disco set id=:pId where isrc=:pDisco";
        q = ss.createQuery(s);
        q.setParameter("pId",2);
        q.setParameter("pDisco","xyz987");
        int result = q.executeUpdate();
        System.out.println("Resultado UPDATE: " + result); */

        // e- borrar una discográfica 3 (creada para la ocasión, no existía)
        System.out.println("- borrar una discográfica 3 (creada para la ocasión, no existía");
        s = "delete Discografica where id=:dId";
        q = ss.createQuery(s);
        q.setParameter("dId",3);
        int result2 = q.executeUpdate();
        System.out.println("Resultado DELETE: " + result2);
    }

}
