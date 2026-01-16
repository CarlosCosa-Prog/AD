package org.example.relaciones;

import jakarta.persistence.*;

import java.io.Serializable;


@DiscriminatorValue("co")
public class Coche extends Auto implements Serializable {
    protected int potencia;

    public Coche(int potencia) {
        this.potencia = potencia;
    }

    public Coche(String matricula, int potencia) {
        super(matricula);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "potencia=" + potencia +
                '}';
    }
}
