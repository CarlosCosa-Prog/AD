package org.examenoscar;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "coche")
public class Coche extends Auto{

    @Column
    private int potencia;

    public Coche() {
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
                ", id=" + id +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
