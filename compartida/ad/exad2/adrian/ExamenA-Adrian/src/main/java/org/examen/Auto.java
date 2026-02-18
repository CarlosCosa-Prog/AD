package org.examen;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "autos")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
// FALTA DISCRIMINATOR VALUE
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Auto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String matricula;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "propietario_id")
    Propietario propietario;

    public Auto (){
    }

    public Auto(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
