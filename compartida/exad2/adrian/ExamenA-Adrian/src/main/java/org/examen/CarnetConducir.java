package org.examen;

import java.io.Serializable;
import jakarta.persistence.*;
@Entity
@Table(name = "carnetsconducir")
public class CarnetConducir implements Serializable {

    @Id
    // GENERATED VALUE
    private Long id;
    @MapsId
    // JOINCOLUMN EN UN SOLO LADO
    // MAPPEDBY INCORRECTO
    @OneToOne(mappedBy = "propietario_id",cascade = CascadeType.PERSIST)    // EL CASCADE EN EL OTRO LADO
    @JoinColumn(name = "propietario_id")
    Propietario propietario1;

    protected String tipo;

    public CarnetConducir(String tipo) {
        this.tipo = tipo;
    }

    public CarnetConducir(){}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
