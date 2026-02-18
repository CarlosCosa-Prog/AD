package org.examen;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Coche")
public class Coche extends Auto implements Serializable {

    protected int potencia;

    public Coche() {}

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
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", potencia=" + potencia +
                '}';
    }
}
