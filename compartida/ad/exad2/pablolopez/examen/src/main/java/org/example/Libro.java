package org.example;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "libros")
// FALTAN EN TODAS LAS CLASES LAS ANOTACIONES TABLE
public class Libro extends ContenidoDigital {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String isbn;

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
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                '}';
    }
}
