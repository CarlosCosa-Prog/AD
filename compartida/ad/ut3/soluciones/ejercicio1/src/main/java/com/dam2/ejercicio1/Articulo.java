package com.dam2.ejercicio1;

import jakarta.persistence.*;

@Entity
@Table(name ="articulos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class Articulo implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String titulo;

    public Articulo() {
    }

    public Articulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String s) {
        this.titulo = s;
    }

    public long getId() {
        return id;
    }

/*    public void setId(long id) {
        this.id = id;
    }*/
}
