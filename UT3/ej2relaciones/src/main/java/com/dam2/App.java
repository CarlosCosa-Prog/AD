package com.dam2;

import com.dam2.ej2relaciones.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
        // Creación del objeto Singleton
        SessionFactory sf = HibernateUtil.getSessionFactory();
        // Creación de la sesio con (openSession o getCurrentSession)
        Session ss = sf.openSession();
        // Creación de la transación con (beginTransaction o getTransaction)
        Transaction tr = ss.beginTransaction();

        Empresa empresa1 = new Empresa("Congelados Martínez");
        Empleado empleado1 = new Empleado("Pepe Perez",1500, empresa1);
        Empleado empleado2 = new Empleado("Antonio Lopez",2000, empresa1);
        empleado2.setEmpresa(empresa1);

        empleado1.setDeporte(new Deporte("Tenis"));
        empleado2.setDeporte(new Deporte("Futbol sala"));

        Usuario usuario1 = new Usuario("pepe", "1234");
        usuario1.setEmpleado(empleado1);    // el usuario 1 es el empleado 1
        Usuario usuario2 = new Usuario("antonio", "5678");
        usuario2.setEmpleado(empleado2);
        empleado1.setUsuario(usuario1);
        empleado2.setUsuario(usuario2);

        Inversor inversor1 = new Inversor("David Garcia");  // constructor sin el parámetr empreasa
        inversor1.getEmpresas().add(empresa1);
        Inversor inversor2 = new Inversor("Inversores del Sureste");
        inversor2.getEmpresas().add(empresa1);
        Empresa empresa2 = new Empresa("Electricidad Fuster");
        inversor1.getEmpresas().add(empresa2);
        empresa1.getInversores().add(inversor1);
        empresa2.getInversores().add(inversor2);
        empresa2.getInversores().add(inversor2);

        // tengo que mirar  Jefe, Tecnico y empresa <-----------------------------------
        Empleado empleado3 = new Empleado("Pepe Perez",1500, "");
        // Persistir primero la empresa y después el empleado
        //ss.persist(empleado1);
        //ss.persist(empleado2);
        ss.persist(empresa1);
        ss.persist(empresa2);
        tr.commit();
    }
}
