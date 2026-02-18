package org.example.relaciones;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "autos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Au")
public class Auto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;  // HAZLO LONG
    protected String matricula;
    @ManyToOne(cascade = CascadeType.PERSIST)
    // EL CASCADE NO ERA AQUÍ Y FALTA EL JOINCOLUMN
    protected Propietario propietario;

    public Auto() {
    }

    public Auto(String matricula) {
        this.matricula = matricula;
    }

    public long getId() {
        return id;
    }

    /*public void setId(long id) {
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
                '}';
    }
}
