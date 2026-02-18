package com.dam2;

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
        String hql = "SELECT d.direccion FROM Discografica d";
        Query<String> q1 = ss.createQuery(hql, String.class);
        List<String> direcciones = q1.list();
        direcciones.forEach(System.out::println);

        // b- cuántos discos tiene cada discográfica sin mostrar la discográfica
        String hql2 = "SELECT count(d.discos) FROM Discografica d, Discos disc WHERE d.id =  disc.discografica.id";

        Query<Long> q2 = ss.createQuery(hql, Long.class);
        List<Long> discos = q2.getResultList();
        System.out.printf("Resultado: " + discos);

        // c- cuántos discos tiene cada discográfica mostrando la discográfica
//        String hql3 = "SELECT d.direcciones FROM Discografia d";
//        Query<String> q3 = ss.createQuery(hql, String.class);
        // ES CON ITERATO()

        // d- el disco "xyz987" se lo asigno a la editorial con id 2
        String hql4 = "INSERT INTO Discografica (discos)" +
                "SELECT 'xyz987'" +
                "WHERE d.id = 2";

        Query q4 = ss.createQuery(hql4);
        int result = q4.executeUpdate();
        System.out.println("resultado: " + result);

        // e- borrar una discográfica 3 (creada para la ocasión, no existía)
        String hql5 = "DELETE FROM Discografica d WHERE d.id = 3";

        Query q5 = ss.createQuery(hql5);
        int result2 = q5.executeUpdate();
        System.out.println("resultado: " + result2);

    }

}
