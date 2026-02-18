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
        Transaction tr = ss.beginTransaction();

        // 	a- muestre las direcciones (sólo direcciones) de todas las discográficas.
        String hql = "SELECT direccion FROM Discografica";
        Query q1 = ss.createQuery(hql, Discografica.class);
        List<String> discograficas = q1.list();
        for (String discografica : discograficas) {
            System.out.println(discografica);
        }

        // b- cuántos discos tiene cada discográfica sin mostrar la discográfica
        System.out.println();
        hql = "SELECT count(d) FROM Discografica g, Disco d where g.nom = d.discografica group by d.discografica";
        Query q2 = ss.createQuery(hql);
        Iterator it = q2.stream().iterator();
        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            System.out.println(obj[0]);
        }

        // c- cuántos discos tiene cada discográfica mostrando la discográfica
        hql = "SELECT count(d), Discografica FROM Discografica g, Disco d where g.nom = d.discografica AND g.nom = : nomDisco ";
        Query q3 = ss.createQuery(hql);
        Iterator it2 = q3.stream().iterator();
        while (it.hasNext()) {
            Object[] obj = (Object[]) it2.next();
            System.out.println("La discografica " + obj[0] + " tiene " + obj[1] + " discos");
        }
        // d- el disco "xyz987" se lo asigno a la editorial con id 2

        // e- borrar una discográfica 3 (creada para la ocasión, no existía)
        hql = "DELETE Discografica WHERE id = 3";
        Query qe = ss.createQuery(hql);
        int result = qe.executeUpdate();
        System.out.println("Filas afectadas: " + result);
    }

}
