package com.amm;

import jakarta.persistence.*;
import org.hibernate.mapping.List;

import java.io.Serializable;

@Entity
@Table(name = "contenidosdigitales")
@Inheritance(strategy = InheritanceType.JOINED) // ESTRATEGIA DE TABLA UNICA
public class ContenidoDigital implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id ;
    public String titulo;
    @ManyToOne
    @JoinColumn
    public Autor autor;


    public ContenidoDigital( String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public ContenidoDigital() {

    }

    public int getId() {
        return id;
    }

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
