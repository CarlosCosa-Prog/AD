package com.amm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction t = ss.beginTransaction();

        Autor a = new Autor("Julian");
        Autor a2 = new Autor("DecimoMeridio");

        ContenidoDigital co = new ContenidoDigital();
        Libro libro = new Libro();
// LOS AUTORES NO SE ESTÁN RELACIONANDO CON EL RESTO DE OBJETOS
        ss.save(a);
        ss.save(a2);

        t.commit();
    }
}
/*
Explica los 4 posibles valores para la propiedad "hbm2ddl" en el fichero hibernate.cfg.xml:

Existen 4 metodos y los 4 sirven para modificar las bases de datos que estamos haciendo:
Create, como su mismo nombre dice es para crear simplemente la base de datos por lo cual la rehara siempre que
la ejecutemos.
Update, el cual es el que viene por defecto y el que utilizaremos en su mayoria ya que es capaz de actualizar tanto
los datos como la estructura de la base de datos creada o por crear
Y el Validate, el metodo que utilizaemos cuando la estructura de la base de datos ya este plentamente lista y preparada
ya que este solo va a cambiar los valores dentro de la tabla y no podrá cambiar la estructura de la misma.
* */
