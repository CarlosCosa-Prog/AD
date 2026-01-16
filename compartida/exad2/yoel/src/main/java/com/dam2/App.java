package com.dam2;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App
{
    public static void main( String[] args ){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession(); // DEBIA SER GETSESSIONFACTORY()
        Transaction tx = session.beginTransaction();

        Biografia biografia1 = new Biografia("Iker tiene 20 años y lleva escribiendo desde hace 5 años");
        Biografia biografia2 = new Biografia("Daniel tiene 50  años y lleva escribiendo 30 años");

        Autor autor1 = new Autor("Iker", biografia1);
        Autor autor2 = new Autor("Daniel", biografia2);

        biografia1.setAutor(autor1);
        biografia2.setAutor(autor2);


        //ContenidoDigital contenidoDigital = new ContenidoDigital("4 lobos", autor1);
        //autor1.getContenidos().add(contenidoDigital);

        Libro libro1 = new Libro("5 lobos", autor2, "09009F");
        autor2.getLibros().add(libro1);


        session.persist(autor1);
        session.persist(autor2);

        tx.commit();
        session.close();
        sf.close();
    }
}

//Explica al final del código fuente los 4 posibles valores para la propiedad hbm2ddl, en le fichero hibernate.cfg.xml
/*
Hay 4 tipos de valores que se le pueden pasar a la propiedad Hbm2ddl que son los siguientes:
    -update: Este valor le da permiso a hibernate a aplicar cambios a en la base de datos (los datos seran correspondientes a nuestras clases java creadas en el programa.
        Este termino lo utilizaremos cuando el proyecto se encuentre en "Produccion".
    -validate: Este valor simplemente comprueba que toda la estructura de las clases java creadas sean correctas, pero no se mostraran los cambios en la entidad de la base de datos.
        Este termino lo utilizaremos cuando el proyecto se encuentre en "Desarrollo".
    -create: Este valor comprobara que no este creada la base de datos y, si no esta creada generara una nueva base de datos con el nombre indicado en el fichero de configuracion de hibernate.
    Si ya teniamos una base de datos creada simplemente procedera a abrirla.
    -create-drop: Este valor creara una nueva base de datos y cuando acabe la ejecución se cerrara la sesión.

 */

// LO DE PRODUCCION Y DESARROLLO ESTÁ COMENTADO A LA INVERSA
