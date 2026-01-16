package org.example;

import org.example.relaciones.Autor;
import org.example.relaciones.Biografia;
import org.example.relaciones.ContenidoDigital;
import org.example.relaciones.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )

    {

        //Creamos la session desde 0 para poder iniciar Hibernate
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();

        //Creamos los objetos que vamos a necesitar para la parte APP

        Autor a1 = new Autor("J.R.R Tolkien");
        Autor a2 = new Autor("J.K Rowling");

        Libro l1 = new Libro("El silmarilion", "LOTR");
        Libro l2 = new Libro("El Hobbit", "LOTR");

        Biografia bi1 = new Biografia("Secretos de una Guerra");

        //Creamos una array para poner dentro de contenido digital los libros
        List<ContenidoDigital> contenidoDigital = new ArrayList<ContenidoDigital>();
        //Los metemos en la array directamente
        contenidoDigital.add(l1);
        contenidoDigital.add(l2);
        //A actor1 le ponemos que tiene sus respectivos libros como contenido
        a1.setContenidos(contenidoDigital);

        //Le ponemos al segundo autor una biografía
        a2.setBiografia(bi1);


        //Asignamos a una Biografia un autor
        bi1.setAutor(a2);

        //Le decimos a los libros que tienen autores asignados
        l1.setAutor(a1);
        l2.setAutor(a2);

        //Persisto los dos actores porque a uno le pongo Biografía y al otro le pongo los libros
        ss.persist(a1);
        ss.persist(a2);






        tx.commit();
        ss.close();
    }

}

//RESOLUCIÓN DE EJERCICIO DE TEORÍA

/*
Los cuatro posibles son:
Validate:Validate es para pasar a parte de producción del proyecto, ya que se interpreta que no se realizarán mas cambios en las tablas
Create:Solo sirve para la creacion de tablas.
Update: Update sirve para estar en fase de desarrollo como proyecto, esto significa que se realizarán mas cambios en las tablas o que se crearán nuevas en caso de no estar creadas.
Create-drop: Sirve para cuando crees las tablas, que se borren después de haberlas creado.





*/
