package com.dam2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.getCurrentSession();
        Transaction t = s.beginTransaction();

        Persona persona = new Persona("Dorotea Basilisca");
        Estudiante estudiante = new Estudiante("Juan Aplicado",129);
        Empleado empleado = new Empleado("Pepe Pelos",1234);
        Email email = new Email("pepe@pepe.com");
        empleado.setEmail(email);
        email.setEmpleado(empleado);
        Despacho despacho = new Despacho("A1");
        empleado.setDespacho(despacho);
        Usuario usuario = new Usuario("pepelos","pelos");
        empleado.setUsuario(usuario);
        Departamento departamento = new Departamento("contabilidad");
        empleado.setDepartamento(departamento);
        departamento.getEmpleados().add(empleado);
        List<Coche> coches = new ArrayList<Coche>();
        Coche c1 = new Coche("Renault Clio","1234ABC");
        coches.add(c1);
        List<Empleado> empleados = new ArrayList<Empleado>();
        empleados.add(empleado);
        c1.setEmpleados(empleados);
        Coche c2 = new Coche("Renault Megane","9234MBC");
        coches.add(c2);
        c2.setEmpleados(empleados);
        empleado.setCoches(coches);

        s.persist(estudiante);
        s.persist(persona);
        s.persist(departamento);
        t.commit();
    }
}
