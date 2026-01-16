package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "carnets")
public class CarnetConducir implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo") // Creamos columna con nombre tipo(B,A1,A2, etc)
    private String tipo;

    @OneToOne
    @MapsId
    @JoinColumn
    private Propietario propietario;

    // Constructor general
    public CarnetConducir() {
    }

    // Constructo con paso por parámetros
    public CarnetConducir(String tipo) {
        this.tipo = tipo;
    }

    // Creamos los setters y getters
    public String getTipo() {
        return tipo;
    }

    public Long getId() {
        return id;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    // Creamos método toString()
    @Override
    public String toString() {
        return "CarnetConducir{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
