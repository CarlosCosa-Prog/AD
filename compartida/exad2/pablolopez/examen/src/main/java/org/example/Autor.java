package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String nombre;
    @OneToOne(mappedBy = "biografia")
    private Autor autor;
    @OneToMany
    @JoinColumn(name = "contendodigital")   // JOINCOLUMN EN EL OTRO LADO DE LA RELACIÓN
    private List<Libro> libros;

    public Autor(Autor autor, List<Libro> libros, String nombre) {
        this.autor = autor;
        this.libros = libros;
        this.nombre = nombre;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "autor=" + autor +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", libros=" + libros +
                '}';
    }
}


