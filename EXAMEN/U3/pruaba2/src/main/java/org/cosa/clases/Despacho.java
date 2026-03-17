package org.cosa.clases;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "despachos")
public class Despacho implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int clave;

    public Despacho() {
    }

    public Despacho(int clave) {
        this.clave = clave;
    }

    public Long getId() {
        return id;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Despacho{" +
                "id=" + id +
                ", clave=" + clave +
                '}';
    }
}
