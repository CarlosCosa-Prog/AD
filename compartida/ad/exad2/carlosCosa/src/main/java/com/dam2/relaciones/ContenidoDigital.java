package com.dam2.relaciones;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "contenidos")
public class ContenidoDigital implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String titulo;
// DEBIA HABER UNA RELACIÓN CON AUTOR
    public ContenidoDigital() {
    }
    public ContenidoDigital(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "ContenidoDigital{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
