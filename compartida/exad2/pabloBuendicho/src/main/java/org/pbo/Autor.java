package org.pbo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
// FALTA ANOTACIÓN TABLE
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_autor")
    private List<ContenidoDigital> contenido = new ArrayList<>();

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "autor")
    private Biografia biografia;


    public Autor() {}

    public Autor(String nombre, List<ContenidoDigital> contenido, Biografia biografia) {
        this.nombre = nombre;
        this.contenido = contenido;
        this.biografia = biografia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ContenidoDigital> getContenido() {
        return contenido;
    }

    public void setContenido(List<ContenidoDigital> contenido) {
        this.contenido = contenido;
    }

    public Biografia getBiografia() {
        return biografia;
    }

    public void setBiografia(Biografia biografia) {
        this.biografia = biografia;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contenido=" + contenido +
                ", biografia=" + biografia +
                '}';
    }
}
