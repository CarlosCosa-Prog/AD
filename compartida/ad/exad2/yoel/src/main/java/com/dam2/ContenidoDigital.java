package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "contenidos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
//FALTA DISCRIMINATOR VALUE
public class ContenidoDigital implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    protected String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;


    public ContenidoDigital() {

    }

    public ContenidoDigital(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "ContenidoDigital{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
