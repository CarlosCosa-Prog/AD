package org.example;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "autos")
// FALTAN LAS ANOTACIONES PARA LA HERENCIA
public class Auto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(name = "matriculas")
    protected String matricula;

    // CARDINALIDADES INVERTIDAS
    @OneToMany
    @JoinColumn(name = "id_propietarios")
    protected List<Propietario> propietarios;

    public Auto() {}

    public Auto(String matricula) {
        this.matricula = matricula;
    }

    public Long getId() {return id;}

    //public void setId(Long id) {this.id = id;}

    public String getMatricula() {return matricula;}

    public void setMatricula(String matricula) {this.matricula = matricula;}

    public List<Propietario> getPropietarios() {return propietarios;}

    public void setPropietarios(List<Propietario> propietarios) {this.propietarios = propietarios;}

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
