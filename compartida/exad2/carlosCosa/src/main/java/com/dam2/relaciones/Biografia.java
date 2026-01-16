package com.dam2.relaciones;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "biografias")
public class Biografia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "texto")
    private String texto;

    public Biografia() {
    }

    public Biografia(String texto) {
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    @Override
    public String toString() {
        return "Biografia{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                '}';
    }
}
