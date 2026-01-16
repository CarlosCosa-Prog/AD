package com.dam2.examenccs;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "propietarios")

public class Propietario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;

    // Relacion 1 a N con Auto (1 es propietario y N es auto)
    // Primero empiezo a hacer la relación desde el 1 (propietario)
    @OneToMany(mappedBy = "propietario",  cascade = CascadeType.PERSIST)
    private List<Auto> autos;

    // Relación 1 a 1 con carnets, hay que poner el mismo nombre del atributo
    @OneToOne(mappedBy = "propietario", cascade = CascadeType.PERSIST)
    private CarnetConducir carnet;

    public Propietario() {
    }

    public Propietario(String nombre, List<Auto> autos, CarnetConducir carnet) {
        this.nombre = nombre;
        this.autos = autos;
        this.carnet = carnet;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public CarnetConducir getCarnet() {
        return carnet;
    }

    public void setCarnet(CarnetConducir carnet) {
        this.carnet = carnet;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", autos=" + autos +
                ", carnet=" + carnet +
                '}';
    }
}
