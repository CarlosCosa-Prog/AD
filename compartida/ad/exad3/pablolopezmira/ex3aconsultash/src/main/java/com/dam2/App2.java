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
        System.out.println("------------------------------");
        String s="select ed.direccion from Editorial ed";
        Query<String> q=ss.createQuery(s,String.class);
        List<String> l=q.getResultList();
        l.forEach(System.out::println);


        //b- cuántos libros tiene cada editorial sin mostrar a la editorial
        System.out.println("------------------------------");
        s="select count(l) from Libro l, Editorial ed where l.editorial=ed group by l.id";
        Query<Long> q2=ss.createQuery(s,Long.class);
        List<Long> l2=q2.getResultList();
        l2.forEach(System.out::println);

        //c- cuántos libros tiene cada editorial mostrando la editorial
        System.out.println("------------------------------");
        s="select count(l) from Libro l, Editorial ed where l.editorial=ed group by l.id";
        Query q3=ss.createQuery(s);
        Iterator iterator=q3.stream().iterator();
        while(iterator.hasNext()){
            Object array[]=(Object[]) iterator.next();
            System.out.println(array[0]+" tiene "+array[1]+" libros");
        }


        //d- el libro "abc123" se lo asigno a la editorial con id 2
        System.out.println("------------------------------");
        String hql="update Libro l set "+"editorial.id=2 where l.isbn='abc123'";
        Query q1=ss.createQuery(hql);
        q1.executeUpdate();
        q1.setProperties(""); //No me acuerdo que poner aqui

        //e- borrar una editorial 3 (creada para la ocasión, no existía)
        System.out.println("------------------------------");
        String hql2="delete from Editorial ed where ed.id=3";
        Query q4=ss.createQuery(hql2);
        q4.executeUpdate();


        //Los ss persist pero vacios ya que no he logrado crearlos bien los cambios
        //ss.persist();
        //ss.persist();
        t.commit();




    }

}
