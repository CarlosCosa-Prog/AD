package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "autos")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
// FALTA DISCRIMINATOR VALUE
public class Auto implements java.io.Serializable {
    // Creamos la clave principal de auto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera los id de manera automática
    private Long id;

    @Column(name = "matricula")
    private String Matricula;

    // Relacion N-1(varios coches pueden ser propiedad de 1 solo propietario)
    @ManyToOne
    @JoinColumn(name = "propietarioid")
    private Propietario propietario;

    public Auto() {
    }

    public Auto(String matricula) {
        Matricula = matricula;
    }

    public Long getId() {
        return id;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String matricula) {
        Matricula = matricula;
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
                ", Matricula=" + Matricula +
                '}';
    }
}
