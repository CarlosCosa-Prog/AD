package com.dam2;

import com.dam2.ch.Editorial;
import com.dam2.ch.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        //a- muestre las direcciones (sólo direcciones) de todas las editoriales.
            String hql = "Select e.direccion from Editorial as e";
            Query q = ss.createQuery(hql);
            List<String> direcciones  = q.list();
            System.out.println("Lista Direcciones: ");
            for (String d : direcciones){
                System.out.println(d);
            }
        //b- cuántos libros tiene cada editorial sin mostrar a la editorial
            String hql2 = "Select count(l.isbn) from Libro l, Editorial e where e.id = l.editorial.id  group by  e.id";
            Query q2 = ss.createQuery(hql2);
            List<Long> numLi = q2.list();
            System.out.println("Cantidad libros");
            for (Long num : numLi){
                System.out.println(num);
            }


        //c- cuántos libros tiene cada editorial mostrando la editorial



        /*
        String hql3 = "Select count(l.isbn), Editorial from Libro l, Editorial e where e.id = l.editorial.id  group by  e.id";
            Query q3 = ss.createQuery(hql3);
            Iterator<Object[]> it = q3.stream().iterator(); // el fallo esta en este paso de aqui debido a que algun tipo de dat hace que iteretor lo borre por completo y lo deje a nulo lo que causo null pointer exception
            while (it.hasNext()) {
                Object[] list = it.next();
                Long n = (Long) list[0];
                Editorial e = (Editorial) list[1];
                System.out.println("La editorial: " + e.getNom() + " tiene " + n.toString() + " libros");
            }
            */

        //d- el libro "abc123" se lo asigno a la editorial con id 2

            String hql4 = "UPDATE Libro set editorial.id = 2 where isbn = 'abc123' ";
            Query q4 = ss.createQuery(hql4);
            int num = q4.executeUpdate(); //numero de filas afectadas
            if (num > 0){
                System.out.println("filas afectadas (actualizada): " + num);
            }


        //e- borrar una editorial 3 (creada para la ocasión, no existía)
        //he creado uno con id 4
            String hql5 = "Delete from Editorial where id = 4";
            Query q5 = ss.createQuery(hql5);
            int num2 = q5.executeUpdate();
            if (num2 > 0){
                System.out.println("filas afectadas (borradas): " + num2);
            }

        t.commit();
    }

}
