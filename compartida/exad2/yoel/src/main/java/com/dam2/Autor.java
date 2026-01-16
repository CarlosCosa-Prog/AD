package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.PERSIST)
    private List<ContenidoDigital> contenidos;
    @OneToOne(mappedBy = "autor",cascade = CascadeType.PERSIST)
    private Biografia biografia;
    // NO HAS DE AÑADIR ESTA RELACIÓN, LOS LIBROS SON CONTENIDOS DIGITALES
    @OneToMany(mappedBy = "autor", cascade = CascadeType.PERSIST)
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(String nombre, Biografia biografia) {
        this.nombre = nombre;
        this.biografia = biografia;
        contenidos = new ArrayList<>();
        libros = new ArrayList<>();
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ContenidoDigital> getContenidos() {
        return contenidos;
    }

    public void setContenidos(List<ContenidoDigital> contenidos) {
        this.contenidos = contenidos;
    }

    public Biografia getBiografia() {
        return biografia;
    }

    public void setBiografia(Biografia biografia) {
        this.biografia = biografia;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contenidos=" + contenidos +
                '}';
    }
}
