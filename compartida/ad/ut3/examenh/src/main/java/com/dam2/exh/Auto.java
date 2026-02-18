package com.dam2.exh;

import jakarta.persistence.*;

import java.io.Serializable;

@Table(name = "autos")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue(value = "A")
public class Auto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String matricula;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    public Auto() {
    }

    public Auto(String matricula, Propietario propietario) {
        this.id = id;
        this.matricula = matricula;
        this.propietario = propietario;
    }

    public Long getId() {
        return id;
    }

 /*   public void setId(Long id) {
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
