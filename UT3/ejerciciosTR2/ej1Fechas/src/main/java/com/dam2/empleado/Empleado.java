package com.dam2.empleado;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // primary key
    @Column
    private String nom;
    @Column
    private double salario;
    @Column
    private GregorianCalendar fechaNacimiento;

    public Empleado() {}

    public Empleado(String nom, double salario,  GregorianCalendar fechaNacimiento) {
        this.nom = nom;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id= " + id +
                ", nom= '" + nom + '\'' +
                ", salario= " + salario +
                '}';
    }
}
