package com.amm;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "biografias")
public class Biografia implements Serializable {

    @Id
    public int id;

    public String texto;

    @MapsId
    @OneToOne(mappedBy = "biografia",cascade = CascadeType.ALL)
    Autor autor;

    public Biografia() {
    }

    public Biografia(String texto) {
        this.id = id;
        this.texto = texto;
    }
    public int getId() {
        return id;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Biografia{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                '}';
    }
}
