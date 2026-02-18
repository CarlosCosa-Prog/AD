package com.dam2;

public class Empleado {
    private int id;

    private String nom;
    private double salario;

    public Empleado() {
    }

    public Empleado(int id, String nom, double salario) {
        this.id = id;
        this.nom = nom;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
                "id=" + id +
                ", nombre='" + nom + '\'' +
                ", salario=" + salario +
                '}';
    }
}

