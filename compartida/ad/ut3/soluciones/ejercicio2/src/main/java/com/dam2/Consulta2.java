package com.dam2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class Consulta2 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        // cuántas personas en cada departamento
        String consulta = "select count(*) from Empleado as e group by e.departamento";
        Query query = s.createQuery(consulta);
        List<Long> valores = query.list();
        for (Long i: valores)
            System.out.println(i);
        // igual pero indicando qué departamento en cada caso
        consulta = "select count(*), e.departamento from Empleado as e group by e.departamento";
        Query query2 = s.createQuery(consulta);
        Iterator valors = query2.iterate();
        while (valors.hasNext())
        {
            Object array[] = (Object []) valors.next();
            System.out.println(array[0] + " empleados en el departamento " + array[1]);
        }

        s.close();
    }
}
