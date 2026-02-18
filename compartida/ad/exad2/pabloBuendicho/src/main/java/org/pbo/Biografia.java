package org.pbo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Biografia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "biografia")
    private Autor autor;


    public Biografia(){}
    public Biografia(String texto, Autor autor) {
        this.texto = texto;
        this.autor = autor;
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

    @Override
    public String toString() {
        return "Biografia{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", autor=" + autor +
                '}';
    }
}
