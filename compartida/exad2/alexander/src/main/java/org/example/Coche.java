package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "coche") // Indicamos el valor discriminatorio
public class Coche extends Auto {
    // Creamos los atributos de la clase
    @Column(name = "potencia") // Indicamos que es una columna de la tabla y que tiene como nombre potencia
    private double potencia;

    public Coche() {
    }

    public Coche(String matricula, double potencia) {
        super(matricula);
        this.potencia = potencia;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }


    @Override
    public String toString() {
        return "Coche{" +
                "potencia=" + potencia +
                '}';
    }
}
