package com.dam2.ejercicio1;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="editoriales")
public class Editorial implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre")
    private String nom;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "editorial")
    private List<Libro> libros;

    public Editorial() {
    }

    public Editorial(String nom) {
        this.nom = nom;
        libros = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

 /*   public void setId(long id) {
        this.id = id;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                //", libros=" + libros +
                '}';
    }
}
