package com.dam2.exh;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "carnets")
public class CarnetConducir implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String tipo;
    @MapsId
    @OneToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    public CarnetConducir() {
    }

    public CarnetConducir( String tipo, Propietario propietario) {
        this.id = id;
        this.tipo = tipo;
        this.propietario = propietario;
    }

    public Long getId() {
        return id;
    }

  /*  public void setId(Long id) {
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
                ", propietario=" + propietario +
                '}';
    }
}
