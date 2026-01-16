package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("libro")
public class Libro extends  ContenidoDigital {
    @Column
    private String isbn;


    public Libro() {
    }

    public Libro(String titulo, Autor autor,String isbn) {
        super(titulo,autor);
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
                super.toStringLibro() +
                "isbn='" + isbn + '\'' +
                '}';
    }
}
