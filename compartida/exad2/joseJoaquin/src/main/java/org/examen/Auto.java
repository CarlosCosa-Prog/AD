package org.examen;

import jakarta.persistence.*;
import java.util.*;

@Entity
// FALTA ANOTACIÓNES PARA TABLA Y HERENCIA
public abstract class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

        // LAS 2 ANOTACIONES SIGUIENTES NO CORRESPONDEN AQUÍ
    @JoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String matricula;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
