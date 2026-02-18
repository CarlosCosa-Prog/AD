package com.dam2;

import com.dam2.exh.Auto;
import com.dam2.exh.CarnetConducir;
import com.dam2.exh.Coche;
import com.dam2.exh.Propietario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/*
*
* */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.getCurrentSession();
        Transaction tr = ss.beginTransaction();

        Auto a1 = new Auto("1111AAA", null);
        Auto a2 = new Coche("2222BBB",null, 100);
        Propietario pr1 = new Propietario("Alfredo Martínez", null);
        CarnetConducir carnet = new CarnetConducir("B",pr1);
        pr1.setCarnet(carnet);
        pr1.getAutos().add(a1);
        pr1.getAutos().add(a2);
        a1.setPropietario(pr1);
        a2.setPropietario(pr1);

        ss.persist(pr1);
        tr.commit();
    }
}
