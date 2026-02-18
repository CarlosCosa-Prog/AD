package org.pbo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = new HibernateUtil().getSf();
        Session ss = sf.openSession();
        Transaction t =  ss.beginTransaction();

        //Creacion del proyecto
        //Primer autor sin libros
        Autor autor = new Autor();

        autor.setNombre("Pablo Buendicho");

        Biografia biografia1 = new Biografia();
        biografia1.setTexto("Es el mejor autor de España");
        biografia1.setAutor(autor);

        autor.setBiografia(biografia1);

        // Segundo autor con libros
        Autor autor2 = new Autor();

        autor2.setNombre("Jorge Vidal");

        ContenidoDigital contenido1 = new ContenidoDigital("Harry Poter y la piedra filosofal", autor2);
        Libro libro = new Libro(contenido1.getTitulo(), contenido1.getAutor(), "123456789");
        autor2.setContenido(contenido1);    // HA DE SER UNA LISTA

        ContenidoDigital contenido2 = new ContenidoDigital("Frankestein", autor2);
        Libro libro2 = new Libro(contenido2.getTitulo(), contenido2.getAutor(), "987654321");
        autor2.setContenido( contenido2);

        Biografia biografia2 = new Biografia();
        biografia1.setTexto("Es el mejor autor de España");
        biografia1.setAutor(autor2);

        autor2.setBiografia(biografia2);

// NO PERSISTAS TODOS, APROVECHA LOS CASCADE
        ss.persist(autor);
        ss.persist(autor2);
        ss.persist(libro);
        ss.persist(libro2);
        ss.persist(contenido1);
        ss.persist(contenido2);
        ss.persist(biografia1);
        ss.persist(biografia2);
        t.commit();
    }
}

/*
2. Explica los 4 posibles valores para la propiedad "hbm2ddl"

    -Esta propiedad que se usa en el archivo de configuracion de hibernate.cfg.xml tiene las siguientes propiedades a utilizar:

        - create: este valor de la propiedad sirve para la creacion de dicha propiedad

        - create-drop: este valor sirve para tirar o borrar una propiedad ya creada

        -update: este es el valor que solemos utilizar nosotros siempre y es para la actualizacion de la propiedad

        -validate: este último valor es para la comprobación del funcionamiento de la propiedad
 */

// DONDE HABLAS DE PROPIEDADES DEBIERAS DECIR TABLAS