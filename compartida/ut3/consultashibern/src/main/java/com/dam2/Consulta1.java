package com.dam2;

import com.dam2.ch.Persona;
import com.dam2.ch.Telefono;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class Consulta1 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        // OBTENER TODAS LAS PERSONAS
        String s = "from ...";

        // LAS DIRECCIONES DE LAS PERSONAS
        System.out.println();
        s = "select ...";


        // TELEFONOS DE LA PERSONA CON ID 1
        System.out.println();
        s = "select ...";

        // TELEFONOS DE LA PERSONA CON ID 1 ORDENADOS ASCENDENTEMENTE
        System.out.println();
        s = "select ...";

        // CUÁNTOS TELÉFONOS TIENE CADA PERSONA SIN MOSTRAR A LA PERSONA
        System.out.println();
        s = "select count() ...";

        // CUÁNTOS TELÉFONOS TIENE CADA PERSONA MOSTRANDO A CADA PERSONA
        System.out.println();
        s = "select count(t), ... from ... where ... group by ...";
        ...;
        Iterator it = ...iterator();
        while (..)
        {
            Object array[] = ...
        }

        // OBTENER PERSONA CON ID IGUAL A 1
        int personaId = 1;
        Persona p = ss.get(...);
        System.out.println("\n" + p);

        // OBTENER DATOS DE LA PERSONA CON TELÉFONO 666555442
        String s2 = "666555442";
        Telefono tlf = ss.get(...);
        System.out.println("\n" +...);

        // REPETIR LA CONSULTA ANTERIOR CON HQL
        s ="Select p from ... where ...";
        ...
        ....uniqueResult();
        System.out.println("\n" +...);

    }

}
