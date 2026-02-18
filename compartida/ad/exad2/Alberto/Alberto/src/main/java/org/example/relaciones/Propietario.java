package org.example.relaciones;

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
    private String nombre;
    @OneToMany()
    private List<Auto> autos;
    @OneToOne(cascade = CascadeType.PERSIST)
    // FALTA MAPPEDBY O JOINCOLUMN, TAMBIÉN MAPSID
    private CarnetConducir carnetConducir;

    public Propietario() {
    }

    public Propietario(String nombre) {
        this.nombre = nombre;
        this.autos = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    /*public void setId(long id) {
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
    public void setAutos(List<Auto> autos) {}

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
                ", autos=" + autos +
                ", carnetConducir=" + carnetConducir +
                '}';
    }
}
