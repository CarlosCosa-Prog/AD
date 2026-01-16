package org.examen;

import java.util.*;
import jakarta.persistence.*;


@Entity
@Table(name = "propietarios")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Auto> autos;

    @OneToOne(cascade = CascadeType.ALL)
    private CarnetConducir carnet;

    private List<Auto> getAutos() {
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
}
