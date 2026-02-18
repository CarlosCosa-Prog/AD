package com.dam2;

import com.dam2.ch.Disco;
import com.dam2.ch.Discografica;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;

public class App2 {
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        // 	a- muestre las direcciones (sólo direcciones) de todas las discográficas.
        System.out.println("muestre las direcciones (sólo direcciones) de todas las discográficas");
        String hql = "SELECT di.direccion From Discografica di";
        Query query = ss.createQuery(hql);
        System.out.println(query.getResultList());
        System.out.println();

        // b- cuántos discos tiene cada discográfica sin mostrar la discográfica
        System.out.println("cuántos discos tiene cada discográfica sin mostrar la discográfica");
        hql = "SELECT size(di.discos) From Discografica di";
        query = ss.createQuery(hql);
        System.out.println(query.getResultList());
        System.out.println();

        // c- cuántos discos tiene cada discográfica mostrando la discográfica
        System.out.println("cuántos discos tiene cada discográfica mostrando la discográfica");
        hql = "SELECT size(di.discos) , di.nom From Discografica di";
        query = ss.createQuery(hql);
        Iterator it = query.stream().iterator();
        while (it.hasNext()) {
            Object[] obj = (Object[]) it.next();
            System.out.println("Numero de discos: " + obj[0]  +  " Nombre de la discografica: "+ obj[1]);
        }

        // d- el disco "xyz987" se lo asigno a la editorial con id 2
        System.out.println();
        System.out.println("el disco xyz987 se lo asigno a la editorial con id 2");
        hql = "UPDATE Disco d SET d.discografica.id = 2 WHERE d.isrc = 'xyz987'";
        query = ss.createQuery(hql);
        int resultado =  query.executeUpdate();
        System.out.println("Filas afectadas: " + resultado);


        System.out.println();
        // e- borrar una discográfica 3 (creada para la ocasión, no existía)
        Discografica dg1 = new Discografica("hola","c/ Del pez, 89");
        Disco d1 = new Disco("xyz234", dg1);
        dg1.getDiscos().add(d1);
        ss.persist(dg1);



        System.out.println("borrar una discográfica 3 (creada para la ocasión, no existía)");
        hql = "DELETE From Disco d WHERE d.isrc = 'xyz234'";
        query = ss.createQuery(hql);
        resultado =  query.executeUpdate();
        System.out.println("Filas afectadas: " + resultado);

        hql = "DELETE FROM Discografica d WHERE d.nom = 'hola'";
        query = ss.createQuery(hql);
        resultado =  query.executeUpdate();
        System.out.println("Filas afectadas: " + resultado);



        t.commit();
    }

}
