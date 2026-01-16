package org.example.relaciones;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "autores")
public class Autor implements Serializable {


    //AQUÍ NO HAY PROBLEMA EN EL ID YA QUE EL ENUNCIADO NO NOS DICE NADA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    //EN ESTA ANOTACIÓN ONETOONE, LE DECIMOS A HIBERNATE QUE BUSQUE EL ATRIBUTO AUTOR EN LA CLASE BIOGRAFIA
    @OneToOne(mappedBy = "autor", cascade = CascadeType.PERSIST)
    private Biografia biografia;

    //EN LA ONETOMANY HACEMOS MAS DE LO MISMO, LE DECIMOS QUE EN LA CLASE CONTENIDODIGITAL BUSQUE EL ATRIBUTO AUTOR
    @OneToMany(mappedBy = "autor", cascade =  CascadeType.PERSIST)
    private List<ContenidoDigital> contenidos;

    public Autor() {}

    //AQUÍ CREAREMOS UN ARRAY DE CONTENIDOS YA QUE NOS PIDE QUE AUTOR DEBE TENER LIBRO
    public Autor(String nombre) {
        this.nombre = nombre;
        contenidos = new ArrayList<>();
    }

    //ESTE CONSTRUCTOR HACE LO MISMO PERO CON BIOGRAFIA PASADO COMO PARAMETRO
    public Autor(String nombre, Biografia biografia) {
        this.nombre = nombre;
        this.biografia = biografia;
        contenidos = new ArrayList<>();
    }


    //IMPORTANTE EN TODAS LAS CLASES QUITAR EL SET ID PORUQE EN TEORIA NO DEBE CAMBIARSE
    public Long getId() {
        return id;
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
