package com.dam2.exh;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "C")
public class Coche extends Auto {
    @Column
    private int potencia;

    public Coche() {
    }

    public Coche(String matricula, Propietario propietario, int potencia) {
        super(matricula, propietario);
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
