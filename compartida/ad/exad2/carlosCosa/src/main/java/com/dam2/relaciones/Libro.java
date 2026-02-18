package com.dam2.relaciones;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table (name = "libros")
public class Libro implements Serializable {
    @Id
    private String isbn;

    public Libro() {
    }

    public Libro(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                '}';
    }

}
