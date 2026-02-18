package org.examen;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getsf();
        Session sesion = sf.openSession();
        Transaction tx = sesion.beginTransaction();

        CarnetConducir carnet1 = new CarnetConducir("B2");

        Auto auto1 = new Auto("271642-KHJ");
        Auto auto2 = new Auto("398735-WLP");    // CREA ALGÚN COCHE

        Propietario prop1 = new Propietario("Adrian");
        Propietario prop2 = new Propietario("Buendicho");
        prop2.addAutos(auto1);
        prop2.addAutos(auto2);
        prop2.setCarnet(carnet1);

        // AUTOS NO TIENEN PROPIETARIOS, NI CARNET
        // FALTA PERSISTIR OBJETOS
        tx.commit();
        sesion.close();
        sf.close();

    }
}


/*

2 HibernateUtil cumple la funcion de mapear las sentencias sql de una mejor manera y mas sencilla en vez de tener que
decomponer con JDBC cada vez que quieres hacer alguna accion, ademas es mas seguro ya que las operaciones se realizan
en bloque sin miedo a que hayan perdidas por el camino o se interrumpa

Session Factory es el que sustituye a JDBC siendo el quien habre la conexion a la base de datos para realizar cualquier
accion.

 */