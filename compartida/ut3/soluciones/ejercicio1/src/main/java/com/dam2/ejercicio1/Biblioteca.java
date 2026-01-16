package com.dam2.ejercicio1;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="bibliotecas")
public class Biblioteca implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String localidad;
    @ManyToMany(mappedBy = "bibliotecas", cascade = CascadeType.PERSIST)
    private List<Libro> libros;

    public Biblioteca() {
    }

    public Biblioteca(String localidad) {
        this.localidad = localidad;
    }

    public long getId() {
        return id;
    }

 /*   public void setId(long id) {
        this.id = id;
    }*/

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "id=" + id +
                ", localidad='" + localidad + '\'' +
                //", libros=" + libros +
                '}';
    }
}
