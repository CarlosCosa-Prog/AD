package com.dam2;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name = "estudiantes")
@DiscriminatorValue(value = "S")
public class Estudiante extends Persona {
    private int numMatricula;

    public Estudiante() {
    }

    public Estudiante(String nom, int numMatricula) {
        super(nom);
        this.numMatricula = numMatricula;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "numMatricula=" + numMatricula +
                ", id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
