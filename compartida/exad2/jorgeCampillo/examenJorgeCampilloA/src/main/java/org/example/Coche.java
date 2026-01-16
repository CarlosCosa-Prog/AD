package org.example;

public class Coche extends Auto {
    protected int potencia;

    public Coche() {}

    public Coche(String matricula, int potencia) {
        super(matricula);
        this.potencia = potencia;
    }

    public int getPotencia() {return potencia;}

    public void setPotencia(int potencia) {this.potencia = potencia;}

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", propietarios=" + propietarios +
                '}';
    }
}
