package com.dam2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        // openSession() crea una conexion nueva
        // getCurrentSession() aprovecha una sesion (ya creada con anterioridad)
        Session ss = sf.getCurrentSession();
        // beginTransaction() crea una transacción nueva
        // getTransaction() aprovecha una transacción (ya creada con anterioridad)
        Transaction tr = ss.beginTransaction();

        Empleado e1 = new Empleado("Emilio", 1200);
        Empleado e2 = new Empleado("Alfredo", 1800);
        ss.persist(e1);
        ss.persist(e2);

        tr.commit();
    }
}
