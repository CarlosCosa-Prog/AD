package com.dam2;

import com.dam2.ch.Disco;
import com.dam2.ch.Discografica;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class App2 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        // 	a- muestre las direcciones (sólo direcciones) de todas las discográficas.
        String s = "select direccion from Discografica";
        Query q = ss.createQuery(s);
        {
            List<String> list = q.getResultList();
            list.forEach(System.out::println);
        }

        // b- cuántos discos tiene cada discográfica sin mostrar la discográfica
        s = "select count(d) from Discografica dg, Disco d WHERE dg.id = d.discografica.id GROUP BY dg.id";
        q = ss.createQuery(s);
        {
            List<Long> list = q.getResultList();
            list.forEach(System.out::println);
        }

        // c- cuántos discos tiene cada discográfica mostrando la discográfica
        s = "select count(d),dg.nom from Discografica dg, Disco d WHERE dg.id = d.discografica.id GROUP BY dg.id";
        q = ss.createQuery(s);
        //Iterator
        System.out.println("ITERATOR");
        Iterator<Object[]> ite = q.getResultStream().iterator();
        while (ite.hasNext()){
            Object[] obj = ite.next();
            System.out.println("La discográfica " + obj[1] + " tiene " + obj[0] + " discos.");
        }
        // List
        System.out.println("LIST");
        List<Object[]> list = q.getResultList();
        list.forEach(obj -> System.out.println("La discográfica " + obj[1] + " tiene " + obj[0] + " discos."));

        // d- el disco "xyz987" se lo asigno a la editorial con id 2
        s = "update Disco d set d.discografica.id=2 where d.isrc = 'xyz987'";
        q = ss.createQuery(s);
        q.executeUpdate();
        t.commit();

        // e- borrar una discográfica 3 (creada para la ocasión, no existía)
        Discografica dg = new Discografica("La calle", "c/ avenida san luis");
        Disco d = new Disco("disc3",dg);
        dg.getDiscos().add(d);
        ss.persist(dg);
        t.commit();

        String s1 = "delete from Disco d where d.discografica.id =3";
        s = "delete from Discografica where id = 3";
        q = ss.createQuery(s);
        Query q1 = ss.createQuery(s1);
        q1.executeUpdate();
        q.executeUpdate();
        t.commit();



    }

}
