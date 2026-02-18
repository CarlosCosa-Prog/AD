package org.examenoscar;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "autos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
// FALTA DISCRIMINATOR VALUE
public class Auto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @Column
    protected String matricula;
    //relacion
    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietario propietario;

    public Auto() {
    }

    public Auto(String matricula) {
        this.matricula = matricula;
    }

    public long getId() {
        return id;
    }
    /*
    public void setId(long id) {
        this.id = id;
    }
    no lo necesitamos ya que no tendria sentido que el usuario pudiera cambiar el id de la BD
     */

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
