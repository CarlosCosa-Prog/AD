package org.examenoscar;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propietarios")
public class Propietario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nombre;
    //relacion
    @OneToMany(mappedBy = "propietario",cascade = CascadeType.PERSIST)
    private List<Auto> autos;
    //relacion
    @OneToOne(mappedBy = "propietario", cascade = CascadeType.PERSIST)
    private CarnetConducir carnet;


    public Propietario() {
        autos = new ArrayList<>();
    }

    public Propietario(String nombre) {
        autos = new ArrayList<>();
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }
/*
    public void setId(long id) {
        this.id = id;
    }
*/
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
