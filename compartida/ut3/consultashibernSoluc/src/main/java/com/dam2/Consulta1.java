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
        String s = "from Persona";
        Query<Persona> q = ss.createQuery(s,Persona.class);
        List<Persona> personas = q.list();
        personas.forEach(p -> System.out.println(p));

        // LAS DIRECCIONES DE LAS PERSONAS
        System.out.println();
        s = "select p.direccion from Persona p";
        Query<String> q2 = ss.createQuery(s,String.class);
        List<String> direcciones = q2.list();
        direcciones.forEach(d -> System.out.println(d));

        // TELEFONOS DE LA PERSONA CON ID 1
        System.out.println();
        s = "select tlfs from Persona where id = 1";
        Query<Telefono> q3 = ss.createQuery(s,Telefono.class);
        List<Telefono> telefonos = q3.list();
        telefonos.forEach(System.out::println);

        // TELEFONOS DE LA PERSONA CON ID 1 ORDENADOS ASCENDENTEMENTE
        System.out.println();
        s = "select t from Persona p, Telefono t where p.id = 1 and t.persona.id = 1 order by t.num asc";
        Query<Telefono> q4 = ss.createQuery(s,Telefono.class);
        telefonos = q4.list();
        telefonos.forEach(System.out::println);

        // CUÁNTOS TELÉFONOS TIENE CADA PERSONA SIN MOSTRAR A LA PERSONA
        System.out.println();
        s = "select count(t) from Persona p, Telefono t where t.persona.id = p.id group by p.id";
        Query<Long> q5 = ss.createQuery(s,Long.class);
        List<Long> valores = q5.list();
        valores.forEach(System.out::println);

        // CUÁNTOS TELÉFONOS TIENE CADA PERSONA MOSTRANDO A CADA PERSONA
        System.out.println();
        s = "select count(t), p.nom from Persona p, Telefono t where t.persona.id = p.id group by p.id";
        Query q6 = ss.createQuery(s);
        Iterator it = q6.stream().iterator();
        while (it.hasNext())
        {
            Object array[] = (Object[]) it.next();
            System.out.println(array[1] + " tiene " + array[0] + " teléfonos");
        }

        // OBTENER PERSONA CON ID IGUAL A 1
        int personaId = 1;
        Persona p = ss.get(Persona.class, personaId);
        System.out.println("\n" + p);

        // OBTENER DATOS DE LA PERSONA CON TELÉFONO 666555442
        String s2 = "666555442";
        Telefono tlf = ss.get(Telefono.class, s2);
        System.out.println("\n" +tlf.getPersona());

        // REPETIR LA CONSULTA ANTERIOR CON HQL
        s ="Select p from Persona p, Telefono t where t.num = :numTlf and t.persona.id = p.id";
        Query q20 = ss.createQuery(s,Persona.class);
        q20.setParameter("numTlf", s2);
        Persona p2 = (Persona) q20.uniqueResult();
        System.out.println("\n" +p2);

    }

}
