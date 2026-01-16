package org.pbo;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Libro")
public class Libro extends ContenidoDigital{
    private String isbn;

    public Libro() {}
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
