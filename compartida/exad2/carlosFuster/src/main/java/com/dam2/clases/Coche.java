package com.dam2.clases;

import jakarta.persistence.*;

// Etiquetas de la clase hija heredada de auto
@Entity
@DiscriminatorValue("coche")
public class Coche extends Auto {
    @Column
    private int potencia;

    // Constructores de la clase
    public Coche() {
    }

    public Coche(String matricula, int potencia) {
        super(matricula);
        this.potencia = potencia;
    }

    // Getters y Setters
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    // toString()
    @Override
    public String toString() {
        return "Coche{" +
                "potencia=" + potencia +
                ", id=" + id +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
