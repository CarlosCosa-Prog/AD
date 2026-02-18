package com.dam2;

import com.dam2.ch.Disco;
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
        String s = "select direccion from Discografica";
        Query<String> query1 = ss.createQuery(s);
        List<String> list1 = query1.getResultList();
        list1.forEach(System.out::println);

        // b- cuántos discos tiene cada discográfica sin mostrar la discográfica
        System.out.println();
        String s2 = "select count(d) from Disco d, Discografica di where d.discografica = di group by d.isrc";
        Query<Long> query2 = ss.createQuery(s2, Long.class);
        List<Long> list2 = query2.list();
        list2.forEach(System.out::println);

        // c- cuántos discos tiene cada discográfica mostrando la discográfica
        System.out.println();
        String s3 = "select count(d), di.nom from Disco d, Discografica di where d.discografica = di order by d.isrc ";
        Query query3 = ss.createQuery(s3);
        Iterator it = query3.stream().iterator();
        while (it.hasNext()){
            Object[] array = (Object[]) it.next();
            Discografica d = (Discografica) array[0];
            Disco disco = (Disco) array[1];
            System.out.println("Discografica: " + d + ", discos: " + disco);
        }

        // d- el disco "xyz987" se lo asigno a la editorial con id 2
        System.out.println();
        String s5 = "UPDATE Disco set Disco.isrc = :disc where Discografica .id = :ed";
        Query query5 = ss.createQuery(s5);
        query5.setParameter("ed", 1);
        query5.setParameter("disc", "xyz987");
        int result2 = query5.executeUpdate();
        System.out.println("Filas afectadas: " + result2);


        // e- borrar una discográfica 3 (creada para la ocasión, no existía)
        System.out.println();
        String s4 = "DELETE FROM Discografica WHERE id= :id";
        Query query4 = ss.createQuery(s4);
        query4.setParameter("id", 3);
        int result = query4.executeUpdate();
        System.out.println("Resultado, filas afectadas: " + result);
    }

}
