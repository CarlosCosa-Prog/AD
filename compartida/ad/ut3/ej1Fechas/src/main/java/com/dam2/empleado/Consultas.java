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

        // obtener el primer Empleado
        Empleado e1 = ss.get(Empleado.class,1);
        System.out.println(e1);

        // otra forma
        String hql = "from Empleado E where E.id = 1";
        Query q = ss.createQuery(hql, Empleado.class);
        Empleado e2 = (Empleado) q.getSingleResult();
        System.out.println(e2);

        hql = "from Empleado order by id desc";
        q = ss.createQuery(hql, Empleado.class);
        List<Empleado> empleados = q.getResultList();
        //empleados.stream().forEach(e -> System.out.println(e));
        empleados.stream().forEach(System.out::println);

        org.hibernate.query.Query q2 = ss.createQuery(hql, Empleado.class);
        Iterator<Empleado> emps = q2.stream().iterator();
        while(emps.hasNext())
            System.out.println(emps.next());
    }
}
