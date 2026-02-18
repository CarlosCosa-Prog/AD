package com.dam2;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "biografias")
public class Biografia implements Serializable {
    @Id
    private Long id;

    @Column
    private String texto;

    @OneToOne
    @MapsId
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Biografia() {
    }

    public Biografia(String texto) {
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Biografia{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", autor=" + autor +
                '}';
    }
}
