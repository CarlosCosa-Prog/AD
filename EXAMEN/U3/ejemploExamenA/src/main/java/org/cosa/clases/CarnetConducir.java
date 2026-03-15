package org.cosa.clases;

import jakarta.persistence.*;

@Entity
@Table(name = "carnets")
public class CarnetConducir {
    @Id
    private Long id;
    @Column
    private String tipo;

    // Relación 1 a 1 con propietario (clave compartida)
    @OneToOne
    @MapsId
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;


    public CarnetConducir() {
    }

    public CarnetConducir(String tipo, Propietario propietario) {
        this.tipo = tipo;
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
