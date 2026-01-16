package org.examenoscar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        //con este session buscamos una conexion que ya exista y la reutilizamos y si no la crea
        Session ss = sf.getCurrentSession();
        Transaction tr = ss.beginTransaction();
       //declaramos los objetos que vamos a utilizar
       Propietario proSinCoches = new Propietario("Yoel");
       Propietario proConCoches = new Propietario("Alejandro");
       //dos coches que le pondremos a Propietaio con coches
       Coche mazda = new Coche("1234GWC",110);
       Coche tiguan = new Coche("4321WCG" , 120);
       //asignamos los coches
       proConCoches.getAutos().add(mazda);
       proConCoches.getAutos().add(tiguan);
       //asignamos los propietarios
        mazda.setPropietario(proConCoches);
        tiguan.setPropietario(proConCoches);
        //Carnets de conducir
        CarnetConducir carnet1 = new CarnetConducir("A");
        CarnetConducir carnet2 = new CarnetConducir("B");
        carnet1.setPropietario(proSinCoches);
        carnet2.setPropietario(proConCoches);
        //asiganamos a los carnets su propietario
        proSinCoches.setCarnet(carnet1);
        proConCoches.setCarnet(carnet2);
        //persisteimos los propietarios
        ss.persist(proSinCoches);
        ss.persist(proConCoches);

        tr.commit();
        //no es necesario cerrar porque get Session lo hace solo

    }
}
