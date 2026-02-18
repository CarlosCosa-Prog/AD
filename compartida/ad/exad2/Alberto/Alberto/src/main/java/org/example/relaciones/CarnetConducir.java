package org.example.relaciones;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "carnets")
public class CarnetConducir implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tipo;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Propietario propietario;

    public CarnetConducir() {
    }

    public CarnetConducir(String tipo) {
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    /*public void setId(long id) {
        this.id = id;
    }*/

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "CarnetConducir{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
