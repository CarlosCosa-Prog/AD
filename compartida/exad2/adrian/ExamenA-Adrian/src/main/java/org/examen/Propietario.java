package org.examen;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propietarios")
public class Propietario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @MapsId
    protected Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "carnet_id")
    CarnetConducir  carnet;

    @OneToMany(cascade =  CascadeType.PERSIST,mappedBy = "auto_id")
    List<Auto> autos;

    protected String nombre;

    public Propietario() {}

    public Propietario(String nombre) {
        this.nombre = nombre;
        ArrayList<Auto> autos1 = new ArrayList<Auto>(autos);
    }

    public Propietario(String nombre, CarnetConducir carnet) {
        this.nombre = nombre;
        this.carnet = carnet;
        ArrayList<Auto> autos1 = new ArrayList<Auto>(autos);
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public CarnetConducir getCarnet() {
        return carnet;
    }

    public void setCarnet(CarnetConducir carnet) {
        this.carnet = carnet;
    }

    public void addAutos(Auto auto) {
        getAutos().add(new Auto());
    }
}
