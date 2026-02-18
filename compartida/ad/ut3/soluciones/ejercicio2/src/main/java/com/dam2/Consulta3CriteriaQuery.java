package com.dam2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Iterator;
import java.util.List;

public class Consulta3CriteriaQuery {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        int valor = 999;
        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Empleado> cq = cb.createQuery(Empleado.class);
        Root<Empleado> r = cq.from(Empleado.class);
        cq.where(cb.equal(r.get("salario"),valor));
        Query<Empleado> q = s.createQuery(cq);
        List<Empleado> lista = q.list();
        System.out.println("Los empleados de salario igual a " + valor + " son:");
        for (Empleado e: lista)
            System.out.println(e.getNom());
// Consulta segunda: cuántos empleados tienen ese salario
        CriteriaQuery<Long> cq2 = cb.createQuery(Long.class);
        Root<Empleado> r2 = cq2.from(Empleado.class);
        cq2.select(cb.countDistinct(r2)).where(cb.equal(r2.get("salario"), valor));
        Query<Long> q2 = s.createQuery(cq2);
        Long result = q2.uniqueResult();
        System.out.println("Número de empleados con salario igual a " + valor + " euros: " + result);

        s.close();
    }
}
