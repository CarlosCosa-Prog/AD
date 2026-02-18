package com.amm;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@DiscriminatorValue("libro")
public class Libro extends ContenidoDigital {
    @Id // NO AÑADAS OTRA CLAVE PRINCIPAL (SEGUNDA)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int isbn;

    public Libro() {

    }

    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn=" + isbn +
                '}';
    }
}
