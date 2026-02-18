package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propietarios")
public class Propietario implements java.io.Serializable {

    // Creamos la clave principal
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Creamos el atributo nombre
    @Column(name = "nombre") // Creamos columna con nombre -> nombre
    private String nombre;

    // Relación 1-N (1 Propietario puede tener varios coches)
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.PERSIST)
    private List<Auto> autos;

    @OneToOne(mappedBy = "propietario", cascade = CascadeType.PERSIST)
    private CarnetConducir carnetConducir;

    public Propietario() {
        autos = new ArrayList<Auto>();
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

    public void addAuto(Auto auto) {
        autos.add(auto);
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
