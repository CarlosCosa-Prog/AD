package org.pcg;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
//Le digo a la base de datos que el nombre de la tabla será autos y no Auto
@Table(name="autos")
public class Auto implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String matricula;

    // Constructores
    public Auto() {
    }
    public Auto(String matricula) {
        this.matricula = matricula;
    }
    //Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    // Método toString que será sobreescrito en coche
    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
