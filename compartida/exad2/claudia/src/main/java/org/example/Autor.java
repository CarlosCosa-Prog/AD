package org.example;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="autores")
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="autor_id")
    Long id;

    @Column
    String nombre;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.PERSIST)
    List<Autor> autores = new ArrayList<>();


    // contructores
    public Autor() {}

    public Autor(String nombre) {
        this.nombre = nombre;
    }

    public Autor(String nombre, List<Autor> autores) {
        this.nombre = nombre;
        this.autores = autores;
    }

    //getters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    //setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public void addAutor(Autor autor) {
        autor.setAutores(autores);
        this.autores.add(autor);
    }

    // toString


    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", autores=" + autores +
                '}';
    }
}
