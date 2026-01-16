package org.dam2.PSP;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "biografias")
public class Biografia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String texto;

    @OneToOne(mappedBy = "biografia")
    private Autor autor;

    public Biografia() {
    }

    public Biografia(String texto) {
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
