package com.dam2.ejercicio1;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name ="libros")
@DiscriminatorValue(value = "libro")
public class Libro extends Articulo implements java.io.Serializable {
    private String isbn;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autorId")
    private List<Autor> autores;
    @ManyToMany
    @JoinTable(name="libros_biblios",joinColumns = {@JoinColumn(name = "id_libro")},inverseJoinColumns = {@JoinColumn(name = "id_biblioteca")})
    private List<Biblioteca> bibliotecas;
    @ManyToOne
    @JoinColumn(name = "editorialId")
    private Editorial editorial;

    public Libro() {
        autores = new ArrayList<>();
    }

    public Libro(String titulo, String i) {
        super(titulo);
        autores = new ArrayList<>();
        isbn = i;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Biblioteca> getBibliotecas() {
        return bibliotecas;
    }

    public void setBibliotecas(List<Biblioteca> bibliotecas) {
        this.bibliotecas = bibliotecas;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public void addAutor(Autor a)
    {
        autores.add(a);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autores=" + autores +
                ", bibliotecas=" + bibliotecas +
                ", editorial=" + editorial +
                '}';
    }
}
