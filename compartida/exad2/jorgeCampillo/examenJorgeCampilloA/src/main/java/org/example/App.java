package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Creamos los propietarios
        Propietario propietario1 = new Propietario("Pablo");
        Propietario propietario2 = new Propietario("Mateo");
        // Creamos los autos
        Auto auto = new Auto("4546E");
        Auto auto2 = new Auto("4767P");
        // Le damos al segundo propietario dos autos
        propietario2.getAuto().add(auto);
        propietario2.getAuto().add(auto2);
    // FALTAN LOS PERSIST()
        tx.commit();
        session.close();
        sf.close();
    }
}
