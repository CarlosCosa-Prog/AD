package com.dam2.ejercicio1;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//@Table(name ="discos")
@DiscriminatorValue(value = "disco")
public class Disco extends Articulo {

    private int duracion;

    public Disco() {
    }

    public Disco(String titulo, int d) {
        super(titulo);
        duracion = d;
    }

    public String getIsbn() {
        return titulo;
    }

    public void setIsbn(String isbn) {
        this.titulo = isbn;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Disco{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
