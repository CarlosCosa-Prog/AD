package org.dam2.PSP;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "contenidos")
@DiscriminatorColumn(name = "contenidos", discriminatorType = DiscriminatorType.STRING)
// FALTA DISCRIMINATOR VALUE E INHERITANCE
public class ContenidoDigital implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // HAZ QUE SEA LONG
    private String titulo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contenido_autor")
    private Autor autor;

    public ContenidoDigital() {
    }

    public ContenidoDigital(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
