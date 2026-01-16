package org.examen;

import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.*;
import java.util.*;


public class App
{
    public static void main(String[] args)
    {

        Session sesion = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx = sesion.beginTransaction();


        Propietario propietario1 = new Propietario();
        Propietario propietario2 = new Propietario();

        Coche c1 = new Coche();
        c1.setMatricula("123ABC");
        c1.setPotencia("1.9TDI");
        c1.setId(1);

        Coche c2 = new Coche();
        c2.setMatricula("456DEF");
        c2.setPotencia("1.1DI");
        c2.setId(2);

        CarnetConducir CarnetB = new CarnetConducir();
        CarnetB.setId(1);
        CarnetB.setTipo("B");


        List<Auto> coches = new ArrayList<>();
        coches.add(c1);
        coches.add(c2);
        propietario1.setAutos(coches);
        propietario1.setId(1);
        propietario1.setNombre("Pepe Coches");
        propietario1.setCarnet(CarnetB);

        propietario2.setId(2);
        propietario2.setNombre("Juan Sin Coches");
        propietario2.setCarnet(CarnetB);
// PORQUÉ NO PERSISTES??
        //sesion.persist(propietario1);
        //sesion.persist(propietario2);
        //sesion.persist(c1);
        //sesion.persist(CarnetB);

        tx.commit();
        sesion.close();

        System.out.println("Datos guardados correctamente");


    }
}

/* Siguen el patrón DAO */
