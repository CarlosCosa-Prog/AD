package org.dam2.PSP;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nombre;

    @OneToMany
    // JOINCOLUMEN EN LA OTRA CLASE, AQUÍ MAPPEDBY Y CASCADE
    @JoinColumn(name = "autor_contenido")
    public List<ContenidoDigital> contenido;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autor_biografia")
    // FALTA MAPSID
    public Biografia biografia;

    public Autor() {
    }

    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
