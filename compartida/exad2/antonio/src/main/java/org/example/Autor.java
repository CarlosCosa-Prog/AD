package org.example;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "autores")
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "biografia") // MAPSID
    private Biografia biografia;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<ContenidoDigital> contenidos;

    public Autor() {
        contenidos = new ArrayList<>();
    }

    public Autor(String nombre, Biografia biografia) {
        this.nombre = nombre;
        this.biografia = biografia;
        contenidos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Biografia getBiografia() {
        return biografia;
    }

    public void setBiografia(Biografia biografia) {
        this.biografia = biografia;
    }

    public List<ContenidoDigital> getContenidos() {
        return contenidos;
    }

    public void setContenidos(List<ContenidoDigital> contenidos) {
        this.contenidos = contenidos;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", biografia=" + biografia +
                ", contenidos=" + contenidos +
                '}';
    }
}
