package org.example;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="contenidosDigitales")
public class ContenidoDigital implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;

    @Column
    String titulo;

    @ManyToOne
    @JoinColumn(name="autor_id")
    Autor autor;

    public ContenidoDigital() {}

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

    public Autor getAutor() {
        return autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "ContenidoDigital{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                '}';
    }
}
