package com.dam2;

import com.dam2.ch.Discografica;
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

        // 	a- muestre las direcciones (sólo direcciones) de todas las discográficas.
        String query1 = "SELECT d.direccion FROM Discografica d";
        Query q = ss.createQuery(query1);
        List<String> discos = q.getResultList();
        for (String disco : discos) {
            System.out.println(disco);
        }
        // b- cuántos discos tiene cada discográfica sin mostrar la discográfica
        String query2 = "SELECT count(discos) FROM Discografica d";
        Query q2 = ss.createQuery(query2);
        List<Long> discos2 = q2.getResultList();
        for (Long disco : discos2) {
            System.out.println(disco);
        }

        // c- cuántos discos tiene cada discográfica mostrando la discográfica


        // d- el disco "xyz987" se lo asigno a la editorial con id 2
        String query3 = "UPDATE Disco SET discografica.id = 2 WHERE Disco.isrc ='xyz987' ";
        Query q3 = ss.createQuery(query3);
        int count = q3.executeUpdate();
        if (count > 0) {
            System.out.println("OK CAMBIO");
        }


        // e- borrar una discográfica 3 (creada para la ocasión, no existía)
        Discografica dg3 = new Discografica("BSB","c/ Del paz, 32");
        ss.persist(dg3);
        t.commit();

        String query4 = "DELETE FROM Discografica d WHERE d.nom = BSB";
        Query q4 = ss.createQuery(query4);
        int Count = q4.executeUpdate();
        if (Count > 0) {
            System.out.println("OK DELETE");
        }


    }

}
