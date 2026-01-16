package org.pcg;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
// Le digo a la base de datos que guarde la tabla Coche con el nombre de coches
@Table(name="coches")   // NO, LA ESTRATEGIA DEBÍA SER TABLA ÚNICA
public class Coche extends Auto{

    private int potencia;

    //Constructores
    public Coche(){
    }
    public Coche(String matricula, int potencia) {
        super(matricula);
        this.potencia = potencia;
    }
    //Setters y getters
    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    //Método toString sobreescrito
    @Override
    public String toString() {
        return "Coche [potencia=" + potencia + "]";
    }

}
