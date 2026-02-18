package com.dam2.clases;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propietarios")
public class Propietario implements Serializable{
    // Id de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    // Llamamos a la clase auto de la relacion 1-N, creando una tabla de estos
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.PERSIST)
    private List<Auto> autos;
    // Llamamos a la clase carnetConducir de la relacion 1-1 con claves compartidas
    @OneToOne(mappedBy = "propietario", cascade = CascadeType.PERSIST)
    private CarnetConducir carnetConducir;

    // Constructores de la clase
    public Propietario() {
        autos = new ArrayList<>();
    }

    public Propietario(String nombre) {
        this.nombre = nombre;
        autos = new ArrayList<>();
    }

    public Propietario(String nombre, List<Auto> autos) {
        this.nombre = nombre;
        this.autos = autos;
    }

    // Getters y Setters
    public CarnetConducir getCarnetConducir() {
        return carnetConducir;
    }

    public void setCarnetConducir(CarnetConducir carnetConducir) {
        this.carnetConducir = carnetConducir;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // toString()
    @Override
    public String toString() {
        return "Propietario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
