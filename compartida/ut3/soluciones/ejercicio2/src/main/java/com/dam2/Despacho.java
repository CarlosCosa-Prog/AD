package com.dam2;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "despachos")
public class Despacho implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;

    public Despacho() {
    }

    public Despacho(String codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Despacho{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
