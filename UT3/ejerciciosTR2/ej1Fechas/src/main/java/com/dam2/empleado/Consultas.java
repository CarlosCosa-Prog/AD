package com.dam2.empleado;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class Consultas {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.getCurrentSession();
        Transaction Tr = ss.beginTransaction();

        // 6. Consultas con HQL
        // obtener el perimero Empleado
        Empleado e1 = ss.get(Empleado.class, 1);
        System.out.println("El empleado consulta es: " + e1);

        String hql = "FROM Empleado E WHERE E.id = 1";   // Nombre de la entidad (en sql seria nombre de la tabla)
        Query q = ss.createQuery(hql,Empleado.class);   // String, objeto Class
        List<Empleado> empleados = q.getResultList();   // El result list devuelve una lista


        /*
        // Maneras de mostrar la lista
        // 1. con un stream forEach al que se le pasa una lambda
        empleados.stream().forEach(e -> System.out.println(e));
        // 2. esta otra
        empleados.stream().forEach(System.out::println);
        */
        // 3. forEach para mostrar la lista
        for (Empleado empleado : empleados) {
            System.out.println("El empleado consulta es: " + empleado);
        }

        org.hibernate.query.Query q2 = ss.createQuery(hql, Empleado.class);
        Iterator<Empleado> emps = q2.stream().iterator();
        // mostrar el contenido del iterator
        while (emps.hasNext()) {
            System.out.println(emps.next());
        }
    }
}
