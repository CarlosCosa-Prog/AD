package com.dam2.empleado;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.getCurrentSession();
        Transaction tr = ss.beginTransaction();

        GregorianCalendar fnac1 = new GregorianCalendar(2005, Calendar.JULY,13);
        GregorianCalendar fnac2 = new GregorianCalendar(2009,Calendar.DECEMBER,23);

        Empleado e1 = new Empleado("Emilio Perez", 1700, fnac1);
        Empleado e2 = new Empleado("Taylor Swift", 1800, fnac2);

        ss.persist(e1);
        ss.persist(e2);
        tr.commit();
    }
}
