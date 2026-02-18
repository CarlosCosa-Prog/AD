package org.example;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "carnets de conducir")
public class CarnetConducir implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "tipos")
    protected String tipo;

    @OneToOne
    @JoinColumn(name = "id_propietarios")
    protected Propietario propietarios;

    public CarnetConducir() {}

    public CarnetConducir(String tipo) {
        this.tipo = tipo;
    }

    public Long getId() {return id;}

    //public void setId(Long id) {this.id = id;}

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {this.tipo = tipo;}

    public Propietario getPropietario() {return propietarios;}

    public void setPropietario(Propietario propietario) {this.propietarios = propietario;}

    @Override
    public String toString() {
        return "CarnetConducir{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", propietario=" + propietarios +
                '}';
    }
}
