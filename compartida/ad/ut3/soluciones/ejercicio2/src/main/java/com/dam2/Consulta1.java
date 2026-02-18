package com.dam2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class Consulta1 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Coche coche = s.get(Coche.class,1L);
        System.out.println("El primer coche es " + coche);
        System.out.println("Ahora listamos todos los coches con una lista:");
        String consulta ="from Coche";
        Query query = s.createQuery(consulta);
        List<Coche> coches = query.list();
        for (Coche c: coches)
            System.out.println(c);
        System.out.println("Ahora listamos todos los coches con un Iterator:");
        Iterator<Coche> iterador = query.iterate();
        query.setFetchSize(5);
        // con cada next() leerá 5 para optimizar los accesos
        while (iterador.hasNext())
            System.out.println(iterador.next());
        // Ahora sólo listamos los modelos de cada coche
        consulta = "select c.modelo from Coche c";
        Query query2 = s.createQuery(consulta);
        List<String> modelos = query2.list();
        for (String m: modelos)
            System.out.println(m);
        // Ahora sólo listamos los modelos de cada coche cuya clave sea mayor que 1, usando WHERE y ORDER
        consulta = "select c.modelo from Coche c where c.id >= 1 order by c.matricula";
        query2 = s.createQuery(consulta);
        modelos = query2.list();
        for (String m: modelos)
            System.out.println(m);
        // ahora consulta de resultado único con uniqueResult()
        consulta = "select c.modelo from Coche c where c.id = 2";
        query2 = s.createQuery(consulta);
        String modelo = (String) query2.uniqueResult();
        System.out.println(modelo);
        // Mostrar las matrículas que empiecen por 1
        consulta = "select c.matricula from Coche as c where c.matricula like '1%'";
        query2 = s.createQuery(consulta);
        List<String> matriculas = query2.list();
        for (String m: matriculas)
            System.out.println(m);
        s.close();
    }
}
