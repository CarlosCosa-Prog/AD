package com.amm;

import jakarta.persistence.*;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.List;

import java.io.Serializable;
import java.lang.reflect.Type;

@Entity
@Table(name = "autores")
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id ;
    public String nombre;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    ContenidoDigital[] contenidoDigital;    // UTILIZA UN ARRAYLIST O VECTOR

    @OneToOne
    @JoinColumn
    Biografia biografia;

    public  Autor() {
    }
    public Autor(String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
