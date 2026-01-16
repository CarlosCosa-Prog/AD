package com.dam2.clases;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "carnets_conducir")
public class CarnetConducir implements Serializable {
    // Id de la tabla
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String tipo;
    // Llamamos a la clase propietario de una relacion 1-1 con claves compartidas
    @OneToOne
    @MapsId
    @JoinColumn(name = "propietario_ID")
    private Propietario propietario;

    // Constructores de la clase
    public CarnetConducir() {
    }

    public CarnetConducir(String tipo) {
        this.tipo = tipo;
    }

    // Getters y Setters
    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // toString()
    @Override
    public String toString() {
        return "CarnetConducir{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
