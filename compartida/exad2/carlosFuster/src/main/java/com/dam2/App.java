package com.dam2;

import com.dam2.clases.Auto;
import com.dam2.clases.CarnetConducir;
import com.dam2.clases.Coche;
import com.dam2.clases.Propietario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

        Auto a1 = new Coche("1234BBB",200);
        Auto a2 = new Coche("4321CCC",129);
        List<Auto> autos = Arrays.asList(a1,a2);
        Propietario p1 = new Propietario("Pepe");
        Propietario p2 = new Propietario("Juan", autos);
        CarnetConducir cc1 = new CarnetConducir("B");
        CarnetConducir cc2 = new CarnetConducir("A2");
// P1 Y P2 SON PROPIETARIOS DE LOS MISMOS COCHES (LA RELACIÓN ES UNO A MUCHOS)
        p1.getAutos().add(a1);
        p1.getAutos().add(a2);
        a1.setPropietario(p1);
        a2.setPropietario(p2);
        p1.setCarnetConducir(cc1);
        p2.setCarnetConducir(cc2);
        cc1.setPropietario(p1);
        cc2.setPropietario(p2);

        ss.persist(p1);
        ss.persist(p2);
        tr.commit();
        ss.close();
    }
}
