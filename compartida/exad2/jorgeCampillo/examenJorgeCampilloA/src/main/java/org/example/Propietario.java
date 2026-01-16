package org.example;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "propietarios")
public class Propietario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "nombres")
    protected  String nombre;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autos")
    protected List<Auto> auto;

    // CLAVES HAN DE SER COMPARTIDAS
    @OneToOne(cascade = CascadeType.PERSIST)
    protected CarnetConducir carnetConducir;

    public Propietario() {}

    public Propietario(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {return id;}

    //public void setId(Long id) {this.id = id;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public List<Auto> getAuto() {return auto;}

    public void setAuto(List<Auto> auto) {this.auto = auto;}

    public CarnetConducir getCarnetConducir() {return carnetConducir;}

    public void setCarnetConducir(CarnetConducir carnetConducir) {this.carnetConducir = carnetConducir;}

    @Override
    public String toString() {
        return "Propietario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", auto=" + auto +
                ", carnetConducir=" + carnetConducir +
                '}';
    }
}
