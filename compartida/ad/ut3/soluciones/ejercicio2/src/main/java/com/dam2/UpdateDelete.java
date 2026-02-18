package com.dam2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class UpdateDelete {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        //
        String hql ="update Empleado set salario = 9000L where departamento.id = :numDep";
        Query query = s.createQuery(hql);
        query.setParameter("numDep",1L);
        query.executeUpdate();

        hql = "delete Empleado where departamento.id = :numDep";
        query = s.createQuery(hql);
        query.setParameter("numDep",2L);
        query.executeUpdate();

        t.commit();
        s.close();
    }
}
