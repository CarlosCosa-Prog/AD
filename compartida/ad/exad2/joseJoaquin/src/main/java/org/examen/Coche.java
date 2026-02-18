package org.examen;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table (name = "coches")
public class Coche extends Auto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @MapsId
    private String potencia;

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }
}