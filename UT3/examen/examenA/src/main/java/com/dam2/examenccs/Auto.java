package com.dam2.examenccs;

import jakarta.persistence.*;

import java.io.Serializable;
// 1 - Escribir las anotaciones
@Table (name = "autos")
@Entity
// Inheritance  DiscriminatorColum  DiscriminatorValue
// solo hemos utilizado el SINGLE_TABLE
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// normalmente es de tipo String
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.CHAR)
// el valor es A por el char
@DiscriminatorValue(value = "A")

// 2 - Clase publica con interfaz Serializable
public class Auto implements Serializable {
    // 3 - id de tipo objeto Long
    @Id
    // Siempre hemos utilizado el Identity
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Column no hace falta mientras no se utilice transient
    @Column
    private String matricula;

    // 4 - Relación 1 a N con propietario (1 es propietario y N es auto)
    // Primero empiezo a hacer la relación desde el 1 (propietario)
    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;    // nombre que le he dado en propietario

    // 5 - Constructores, Setters y Getters, toString()

    public Auto() {
    }

    public Auto(String matricula, Propietario propietario) {
        this.matricula = matricula;
        this.propietario = propietario;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", propietario=" + propietario +
                '}';
    }
}