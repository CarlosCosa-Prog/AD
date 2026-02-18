package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App
{
    public static void main( String[] args )
    {
        SessionFactory sf= HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.beginTransaction();

        Autor claudia = new Autor("Claudia da Silva");

        Autor pedro = new Autor("Pedro Sanchez");
        ContenidoDigital libro1 = new ContenidoDigital("Libro uno",pedro);
        ContenidoDigital libro2 = new ContenidoDigital("Libro dos",pedro);
        pedro.addAutor(pedro);

        session.persist(claudia);
        session.persist(pedro);

        tx.commit();
        session.close();
        sf.close();
    }
}

/* Respuesta Actividad 2
*  los posibles valores para la propiedad "hbm2ddl" son:
*   1. create: siempre crea los elementos en el banco de datos, es decir, si hay datos anteriores los sobreescribe. No debe ser usado en produccion.
*   2. update: verifica si hay cambios y los actualiza. Usado en ambiente de desarrollo.
*   3. validate: valida el modelo, si hay diferencias, levanta un error. Es el modelo para produccion.
*   4. create-drop: crea los elementos y los borra al finalizar la sessión. Para desarrollo
* */

