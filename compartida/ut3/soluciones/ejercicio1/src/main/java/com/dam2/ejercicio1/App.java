package com.dam2.ejercicio1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        Libro libro= new Libro("Tirant lo blanc","tlb");
        Autor autor1 = new Autor("anonimo",0);
        //List<Autor> autores = new ArrayList<Autor>();
        //autores.add(autor1);
        libro.addAutor(autor1);
        Biografia biografia = new Biografia("autor desconocido");
        // CON EL AUTOR SE HA DE GUARDAR LA BIOGRAFIA ...
        autor1.setBiografia(biografia);
        // ... PERO LA BIOGRAFIA HA DE CORRESPONDER AL AUTOR
        biografia.setAutor(autor1);

        Libro libro2= new Libro("Don Quijote de la Mancha","dqlm");
        Autor autor2 = new Autor("Cervantes",1570);
        //List<Autor> autores2 = new ArrayList<Autor>();
        //autores.add(autor2);
        libro2.addAutor(autor2);
        Biografia biografia2 = new Biografia("el manco de Lepanto");
        autor2.setBiografia(biografia2);
        biografia2.setAutor(autor2);

        Biblioteca bb1 = new Biblioteca("Novelda");
        Biblioteca bb2 = new Biblioteca("Petrer");
        List<Biblioteca> bibliotecas = new ArrayList<>();
        bibliotecas.add(bb1); bibliotecas.add(bb2);
        libro.setBibliotecas(bibliotecas);
        libro2.setBibliotecas(bibliotecas);

        Editorial editorial = new Editorial("Vinalopó");
        editorial.getLibros().add(libro);
        editorial.getLibros().add(libro2);
        libro.setEditorial(editorial);
        libro2.setEditorial(editorial);

        Disco disco = new Disco("Nevermind de Nirvana",45);
        ss.persist(disco);
        ss.persist(bb1);
        ss.persist(bb2);
        ss.persist(editorial);
        t.commit();

        ss.close();
    }
}
