package org.pcg;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Creo la conexión a la base de datos
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
        // Comienzo con la creación de las clases
        // Creo 2 propietarios
        Propietario propietario1 = new Propietario("Pedro Abascal");
        Propietario propietario2 = new Propietario("Santiago Sánchez");
        // Creo 2 coches
        Auto coche1 = new Coche("wt4 98", 107);
        Auto coche2 = new Coche("sf9 21",95);
        // Creo un arrray con los 2 coches
        ArrayList<Auto> coches = new ArrayList<>();
        coches.add(coche1);
        coches.add(coche2);
        // Se lo paso a un propietario
        propietario1.setCoches(coches);
        //Persisto los propietarios
        ss.persist(propietario1);
        ss.persist(propietario2);

        // FALTA COMMIT, SIN ÉL NO SIRVE DE NADA LO ANTERIOR
    }
}
// Ejercicio 2. La función que cumplen las clases de hibernateUtil y SessionFactory es la de configurar y crear la ruta de conexión entre la App
// y la base de datos.
