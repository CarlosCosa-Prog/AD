package com.dam2.ch;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "libros")
public class Libro implements Serializable {
    @Id
    private String isbn;
    @ManyToOne
    @JoinColumn(name = "editorialId")
    private Editorial editorial;

    public Libro() {
    }

    public Libro(String isbn, Editorial editorial) {
        this.isbn = isbn;
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String num) {
        this.isbn = num;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", Editorial=" + editorial.getNom() +
                '}';
    }
}
