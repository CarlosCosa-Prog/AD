package com.dam2;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "libro")
public class Libro extends ContenidoDigital {
    @Column
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "contenido_id")
    private Autor autor;

    public Libro() {
    }

    public Libro(String titulo, Autor autor, String isbn) {
        super(titulo, autor);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public Autor getAutor() {
        return autor;
    }

    @Override
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
