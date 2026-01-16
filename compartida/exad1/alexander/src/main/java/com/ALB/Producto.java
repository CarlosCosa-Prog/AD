package com.ALB;


public class Producto {
    private int id;

    private String nom;
    private double precio;

    public Producto() {
    }

    public Producto(int id, String nom, double precio) {
        this.id = id;
        this.nom = nom;
        this.precio = precio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nom + '\'' +
                ", precio=" + precio +
                '}';
    }
}
