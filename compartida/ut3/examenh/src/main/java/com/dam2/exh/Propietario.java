package com.dam2.exh;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propietarios")
public class Propietario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.PERSIST)
    private List<Auto> autos;
    @OneToOne(mappedBy = "propietario", cascade = CascadeType.PERSIST)
    private CarnetConducir carnet;

    public Propietario() {
        autos = new ArrayList<>();
    }

    public Propietario(String nombre, CarnetConducir carnet) {
        this.nombre = nombre;
        autos = new ArrayList<>();
        this.carnet = carnet;
    }

    public Long getId() {
        return id;
    }

 /*   public void setId(Long id) {
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
