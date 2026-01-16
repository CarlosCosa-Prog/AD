package com.dam2;

import com.dam2.ch.Persona;
import com.dam2.ch.Telefono;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

/* Errores que me han pasado y como solucionarlos.
    ClassCastException: el tipo de dato que devuelve la consulta no coincide con el tipo de la lista que estás usando
    ejemplo:
        Error
        List<Persona> direcciones = q.getResultList();
        for (Perosona direccion : direcciones) {
            System.out.println(direccion);
        }
        Correccion
        List<String> direcciones = q.getResultList();
        for (String direccion : direcciones) {
            System.out.println(direccion);
        }
    NullPointerException: Intentas usar un objeto que es null
*/
public class Consulta1{
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        // OBTENER TODAS LAS PERSONAS
        System.out.println("Consulta 1 - Obtener todas las personas: ");
        System.out.println("-----------------------------------------------------------------------------");
        String hql = "FROM Persona";  // nombre de la entidad (Persona) tabla (personas)
        Query q = ss.createQuery(hql);
        List<Persona> personas = q.getResultList();
        for (Persona persona : personas) {
            System.out.println(persona);
        }
        //  System.out.println(q.getResultList());  // mostrar el contenido en una sola linea

        // LAS DIRECCIONES DE LAS PERSONAS
        System.out.println("\nConsulta 2 - Obtener las direcciones de las personas: ");
        System.out.println("-----------------------------------------------------------------------------");
        hql = "SELECT direccion FROM Persona";
        q = ss.createQuery(hql);
        List<String> direcciones = q.getResultList();
        for (String direccion : direcciones) {
            System.out.println(direccion);
        }

        // TELEFONOS DE LA PERSONA CON ID 1
        System.out.println("\nConsulta 3 - Obtener el telefono de la persona con ID 1: ");
        System.out.println("-----------------------------------------------------------------------------");
        hql = "SELECT tlfs FROM Persona WHERE id = 1";
        q = ss.createQuery(hql);
        List<Telefono> telefonos = q.getResultList();
        for (Telefono telefono : telefonos) {
            System.out.println(telefono);
        }

        // TELEFONOS DE LA PERSONA CON ID 1 ORDENADOS ASCENDENTEMENTE
        System.out.println("\nConsulta 4 - Obtener el telefono de la persona con ID 1 ordebados ascendentemente: ");
        System.out.println("-----------------------------------------------------------------------------");
        hql = "SELECT tlfs FROM Persona WHERE id = 1 ORDER BY id ASC";
        q = ss.createQuery(hql);
        List<Telefono> telefonos2 = q.getResultList();
        for (Telefono telefono : telefonos2) {
            System.out.println(telefono);
        }

        // CUÁNTOS TELÉFONOS TIENE CADA PERSONA SIN MOSTRAR A LA PERSONA
        System.out.println("\nConsulta 5 - Numero de telefonos de cada persona, sin mostrar a la persona");
        System.out.println("-----------------------------------------------------------------------------");
        hql =   "select count(t) FROM Persona p, Telefono t"+
                " WHERE t.persona.id = p.id "+
                " GROUP BY p.id";
        q = ss.createQuery(hql);
        List<Long> numeros = q.getResultList();
        for (Long numero : numeros) {
            System.out.println(numero);
        }


        // CUÁNTOS TELÉFONOS TIENE CADA PERSONA MOSTRANDO A CADA PERSONA
        System.out.println("\nConsulta 6 - Numero de telefonos de cada persona, mostrando a cada persona");
        System.out.println("-----------------------------------------------------------------------------");
        hql =   " SELECT p,count(t) FROM Persona p, Telefono t"+
                " WHERE t.persona.id = p.id "+
                " GROUP BY p";

        q = ss.createQuery(hql);
        Iterator it = q.list().iterator();
        while (it.hasNext())
        {
            Object array[] = (Object[]) it.next();
            Persona persona = (Persona) array[0];
            Long telefono = (Long) array[1];
            System.out.println(persona);
            System.out.println("Cantidad de telefonos: " + telefono);
        }

        // OBTENER PERSONA CON ID IGUAL A 1
        /*System.out.println("\nConsulta 7 - Persona con ID = 1");
        System.out.println("-----------------------------------------------------------------------------");
        int personaId = 1;
        hql = " SELECT id FROM Persona WHERE id = " + personaId;
        q = ss.createQuery(hql);
        Persona p = ss.get(...);
        System.out.println("\n" + p);

        // OBTENER DATOS DE LA PERSONA CON TELÉFONO 666555442
        String s2 = "666555442";
        Telefono tlf = ss.get(...);
        System.out.println("\n" +...);

        // REPETIR LA CONSULTA ANTERIOR CON HQL
        hql ="Select p from ... where ...";
        ...
        ....uniqueResult();
        System.out.println("\n" +...);*/

    }
}
