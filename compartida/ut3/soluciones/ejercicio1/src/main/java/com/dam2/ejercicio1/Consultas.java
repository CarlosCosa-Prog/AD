package com.dam2.ejercicio1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class Consultas
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();

        Articulo a1 = ss.get(Articulo.class,1);
        System.out.println(a1);

        System.out.println("Mostrando artículos con el método list ...");
        Query q = ss.createQuery("from Articulo ");
        List<Articulo> as = q.getResultList();
        as.stream().forEach(a -> System.out.println(a));

        System.out.println("Mostrando artículos con el método iterate ...");
        q.setFetchSize(5);
        Iterator it = q.stream().iterator();
        while (it.hasNext())
            System.out.println(it.next());

        // Consulta sobre más de una clase
        System.out.println("\nMostrando libros con sus editoriales y ordenados por título\n");
        String hql = "FROM Libro L, Editorial E WHERE L.editorial.id = E.id order by L.titulo";
        Query q2 = ss.createQuery(hql);
        Iterator it2 = q2.stream().iterator();
        while (it2.hasNext()) {
            Object par[] = (Object[]) it2.next();
            Libro lib = (Libro) par[0];
            Editorial ed = (Editorial) par[1];
            System.out.println(lib);
            System.out.println(ed);
        }

        ss.close();
    }
}
