package org.example;

import jakarta.persistence.*;
import org.hibernate.annotations.GeneratedColumn;

import java.io.Serializable;
@Entity
@Table(name = "contenidos_digitales")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class ContenidoDigital implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column
    protected String titulo;

    @ManyToOne
    @JoinColumn(name = "autor")
    protected Autor autor;


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

    public String toStringLibro(){
        return  "id=" + id +
                ", titulo='" + titulo + '\'';
    }

    @Override
    public String toString() {
        return "ContenidoDigital{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
