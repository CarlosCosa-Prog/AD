package org.examenoscar;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "carnets")
public class CarnetConducir implements Serializable {
    @Id
    private long id;
    @Column
    private String tipo;
    //relacion con claves compartidas
    @OneToOne
    @MapsId
    @JoinColumn(name = "id_propietario")
    private Propietario propietario;

    public CarnetConducir() {
    }

    public CarnetConducir(String tipo) {
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }
/*
    public void setId(long id) {
        this.id = id;
    }
*/
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
