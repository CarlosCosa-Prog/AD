package com.dam2.ch;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "editoriales")
public class Editorial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nom;
    @Column
    private String direccion;
    @OneToMany(mappedBy = "editorial", cascade = CascadeType.PERSIST)
    private List<Libro> libros;
    public Editorial() {
    }

    public Editorial(String nom, String direccion) {
        this.nom = nom;
        this.direccion = direccion;
        libros = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> tlfs) {
        this.libros = tlfs;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", direccion='" + direccion + '\'' +
                ", libros=" + libros +
                '}';
    }
}
