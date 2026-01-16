package com.dam2;

import com.dam2.ch.Persona;
import com.dam2.ch.Telefono;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class CUD {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        // INSERTAR EL TELEFONO 666111222 CON PROPIETARIO LA PERSONA CON ID 1
        String hql = "INSERT INTO Telefono (num, persona) " +
                "SELECT '666111222', p FROM Persona p WHERE p.id = :pers";
        Query q = ss.createQuery(hql);
        q.setParameter("pers", 1);
        int result = q.executeUpdate();
        System.out.println("Filas afectadas: " + result);

        // EL TLF 666555443 SE LO ASIGNO A LA PERSONA CON ID 2
        hql = "UPDATE Telefono set persona.id = :pers WHERE num = :num";
        Query q2 = ss.createQuery(hql);
        q2.setParameter("pers", 2);
        q2.setParameter("num", "666555443");
        result = q2.executeUpdate();
        System.out.println("Filas afectadas: " + result);

        // Borrar una Persona 3 (creada para la ocasión, no existía)
        hql = "DELETE FROM Persona WHERE id = :pers";
        Query q3 = ss.createQuery(hql);
        q3.setParameter("pers", 3);
        result = q3.executeUpdate();
        System.out.println("Filas afectadas: " + result);

        t.commit();
    }

}
