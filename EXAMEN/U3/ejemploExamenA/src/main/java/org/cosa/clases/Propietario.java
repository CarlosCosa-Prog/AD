package org.cosa.clases;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propietarios")
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    // Relación 1 a N con Auto (Propietario es 1)
    @OneToMany(mappedBy = "propietario",cascade = CascadeType.PERSIST)
    private List<Auto> autos;

    // Relacion 1 a 1 con CarnetConducir
    @OneToOne(mappedBy = "propietario",cascade = CascadeType.PERSIST)
    private CarnetConducir carnetConducir;

    public Propietario() {
        autos = new ArrayList<>();
    }

    public Propietario(String nombre) {
        this.nombre = nombre;
        this.autos = new ArrayList<>();
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

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public CarnetConducir getCarnetConducir() {
        return carnetConducir;
    }

    public void setCarnetConducir(CarnetConducir carnetConducir) {
        this.carnetConducir = carnetConducir;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
