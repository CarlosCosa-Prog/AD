package com.dam2.clases;

import jakarta.persistence.*;

import java.io.Serializable;

// Etiquetas de la clase padre Auto
@Entity
@Table(name = "autos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
// FALTA DISCRIMINATOR VALUE
public class Auto implements Serializable {
    // Id de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String matricula;
    // Llamamos a la clase propietario en un 1-N
    @ManyToOne
    @JoinColumn(name = "propietario_ID")
    Propietario propietario;

    // Constructores de la clase
    public Auto() {
    }

    public Auto(String matricula) {
        this.matricula = matricula;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // toString()
    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
