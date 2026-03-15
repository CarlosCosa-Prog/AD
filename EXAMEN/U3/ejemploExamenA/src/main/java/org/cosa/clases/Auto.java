package org.cosa.clases;

import jakarta.persistence.*;

@Entity
@Table(name = "autos")
// Relacion de herencia con Coche
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_auto")
@DiscriminatorValue("auto")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String matricula;

    // Relación 1 a N con Propietario (Auto es N)
    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    public Auto() {
    }

    public Auto(String matricula) {
        this.matricula = matricula;
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
