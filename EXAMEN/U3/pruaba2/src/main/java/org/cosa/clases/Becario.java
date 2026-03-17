package org.cosa.clases;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bacarios")
@DiscriminatorValue("becario")
public class Becario extends Persona{
    @Column
    private int horasFormacion;

    public Becario() {
    }

    public Becario(String nombre) {
        super(nombre);
    }

    public Becario(String nombre, int horasFormacion) {
        super(nombre);
        this.horasFormacion = horasFormacion;
    }

    public int getHorasFormacion() {
        return horasFormacion;
    }

    public void setHorasFormacion(int horasFormacion) {
        this.horasFormacion = horasFormacion;
    }

    @Override
    public String toString() {
        return "Becario{" +
                "horasFormacion=" + horasFormacion +
                '}';
    }
}
