package com.dam2.ch;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "discos")
public class Disco implements Serializable {
    @Id
    private String isrc;
    @ManyToOne
    @JoinColumn(name = "discograficaId")
    private Discografica discografica;

    public Disco() {
    }

    public Disco(String isrc, Discografica discografica) {
        this.isrc = isrc;
        this.discografica = discografica;
    }

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String num) {
        this.isrc = num;
    }

    public Discografica getEditorial() {
        return discografica;
    }

    public void setEditorial(Discografica discografica) {
        this.discografica = discografica;
    }

    @Override
    public String toString() {
        return "Disco{" +
                "isrc='" + isrc + '\'' +
                ", Discográfica=" + discografica.getNom() +
                '}';
    }
}
