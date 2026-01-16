package org.example;

import jakarta.persistence.Transient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();
        // Creamos los 2 propietarios
        Propietario prop1 = new Propietario("Alexander");
        Propietario prop2 = new Propietario("Yoel");

        // Creamos los coches
        Coche c1 = new Coche("2403KPL", 220);
        Coche c2 = new Coche("2233LOP", 140);
        prop2.getAutos().add(c1); // Añadimos al propietario el auto
        prop2.getAutos().add(c2);
        c1.setPropietario(prop2); // Establecemos como dueño del auto el prop2
        c2.setPropietario(prop2);

        // Volcamos los cambios en la base de datos con persist
        ss.persist(prop1);
        ss.persist(prop2);
        t.commit();
        ss.close();
    }
}
/*
* Cumplen el patron de software FPA debido a que el hibernateUtil permite limitar la cantidad de conexiones a 1 evitando que
* se creen nuevos hilos en la creación de objetos de una clase, mejorando así la eficiencia del programa. Y el SessionFactory
* nos permite abrir una sessión de ejecución en la cual podremos realizar las modificaciones pertinentes a la base de datos con
* métodos como el persist, save, delete, etc.
* */
