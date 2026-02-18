package com.dam2;

import com.dam2.ch.Disco;
import com.dam2.ch.Discografica;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class App2 {
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        // 	a- muestre las direcciones (sólo direcciones) de todas las discográficas.
        String hql = "SELECT d.direccion From Discografica d";
        Query query = ss.createQuery(hql);
        List<Discografica> discograficas = query.getResultList();
        System.out.println("Direccion de las discograficas --> " + discograficas);


        // b- cuántos discos tiene cada discográfica sin mostrar la discográfica
        hql = "SELECT count(dis) from Disco dis";
        query = ss.createQuery(hql);
        List<Disco>  discos = query.getResultList();
        System.out.println("Numero de Discos --> " + discos);


        // c- cuántos discos tiene cada discográfica mostrando la discográfica
        hql = "SELECT count(dis), d.nom from Disco dis, Discografica d where d.id = dis.discografica.id group by d.id";
        query = ss.createQuery(hql);
        Iterator it = query.getResultList().iterator();
        while (it.hasNext()) {
            Object item[] = (Object[]) it.next();
            System.out.println("La discografica --> " + item[1] + " tiene --> " + item[0] + " discos");
        }


        // d- el disco "xyz987" se lo asigno a la editorial con id 2
        hql = "UPDATE Disco d SET discografica.id = 2 Where d.isrc = 'xyz987'";
        query = ss.createQuery(hql);
        int result = query.executeUpdate();
        System.out.println("Se han actualizado --> " + result + " filas");


        // e- borrar una discográfica 3 (creada para la ocasión, no existía)

        Discografica discografica = new Discografica("NYTimes" ,"C/ Camuñas");
        Disco d1 = new Disco("mongo", discografica);
        List<Disco> discos1  = new ArrayList<>();
        discos1.add(d1);
        discografica.setDiscos(discos1);
        ss.persist(discografica);


        //BORRO ANTES EL DISCO PORQUE TIENEN RELACIÓN ENTRE TABLAS Y SI NO NO HARÁ EL COMMIT COMO QUEREMOS.
        hql = "DELETE Disco d Where d.isrc = 'mongo'";
        query = ss.createQuery(hql);
        result = query.executeUpdate();
        System.out.println("Se han eliminado --> " + result + " filas");

        hql = "DELETE Discografica d WHERE d.nom = 'NYTimes'";
        query = ss.createQuery(hql);
        result = query.executeUpdate();
        System.out.println("Se han eliminado --> " + result + " filas");

        t.commit();
        ss.close();

    }

}
