package org.example;

import org.example.relaciones.Auto;
import org.example.relaciones.CarnetConducir;
import org.example.relaciones.Coche;
import org.example.relaciones.Propietario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import static org.example.HibernateUtil.sf;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory(); // NO: MÉTODO ESTÁTICO DE HIBERNATEUTIL
        Session ss = sf.getCurrentSession();
        Transaction t = ss.beginTransaction();

        Propietario propietario1 = new Propietario("paco");
        Propietario propietario2 = new Propietario("carlos");

        CarnetConducir carnetConducir = new CarnetConducir("B1");
        CarnetConducir carnetConducir2 = new CarnetConducir("C");

        propietario1.setCarnetConducir(carnetConducir);
        propietario2.setCarnetConducir(carnetConducir2);
// CARNET CONDUCIR NO TIENE PROPIETARIO Y AUTO TAMPOCO
        Auto auto1 = new Auto("AB5687S");
        Auto auto2 = new Auto("AB8724S");


        ss.persist(propietario1);   // NO DEBIA HACER FALTA PERSISTIR TODO
        ss.persist(propietario2);
        ss.persist(carnetConducir);
        ss.persist(carnetConducir2);
        ss.persist(auto1);
        ss.persist(auto2);
        t.commit();
        ss.close();


    }
}

//Patron de software que cumple las clases HibernateUtil y SessionFactory y como hacen para cumplirlo

