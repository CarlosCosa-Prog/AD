package com.dam2.examenccs;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
// no es necesario el table, ya que no hay como tal una tabla coches
@DiscriminatorValue(value = "C")

// clase derivada de Auto (no es necesario poner otra vez el id)
public class Coche extends Auto{

    @Column
    private int potencia;

    // En generate se escoge el constructor sin parámetros de Auto
    public Coche() {
    }
    // En cambio en este se escoge el constructor con parámetros de Auto
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
