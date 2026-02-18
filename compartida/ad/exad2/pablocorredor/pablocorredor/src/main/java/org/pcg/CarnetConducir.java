package org.pcg;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name="carnetsconducir")
public class CarnetConducir implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String tipo;

    //Construtores
    public CarnetConducir() {
    }
    public CarnetConducir(String tipo) {
        this.tipo = tipo;
    }
    //Getter y setter
    public Long getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    //Método toString
    @Override
    public String toString() {
        return "CarnetConducir{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
