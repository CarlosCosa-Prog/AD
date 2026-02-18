package org.dam2.PSP;

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
        Transaction tx = ss.beginTransaction();

        Autor autor1 = new Autor(1, "Pablo Sogorb");
        Autor autor2 = new Autor(2, "Paco Serrano");

        Libro libro = new Libro(1, "Pedro picapiedras", 2324);
        libro.setAutor(autor2);

        Biografia biografia = new Biografia("La vida de Pablo");
        Biografia biografia2 = new Biografia("La vida de Paco");
        biografia.setAutor(autor1);
        biografia2.setAutor(autor2);

        ContenidoDigital contenidoDigital = new ContenidoDigital(1, "Contenido autor 1");
        List<ContenidoDigital> contenidoDigitals = Arrays.asList(contenidoDigital);
        autor1.getContenido();
        autor1.setContenido(contenidoDigitals);

        // CON AUTOR DEBIA PERSISTIR BIOGRAFIA Y LIBROS
        ss.persist(biografia);
        ss.persist(libro);
        tx.commit();


    }
}


/*
* Ejercicio 2:
* Los 4 posibles valores para la propiedad "hbm2ddl" son: Create, Create-drop, Update, Validate:
* Create: valor que se pone a la hora de crear la base de datos.
* Create-drop: cuando quieres crea la base de datos.
* Update: significa cuando lo tienes en desarrollo, cuando la base de datos la tienes en desarrollo, osea cuando estás haciendo
    cambio en ella, modificando el código para añadir más tablas.
* Validate es cuando ya tienes la base de datos en producción, la tienes en marcha y lo cambios que hagas no se van a guardar en ella.
* */
