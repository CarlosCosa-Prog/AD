package org.example;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "biografias")
public class Biografia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String texto;
    @OneToOne(mappedBy = "biografia",cascade = CascadeType.ALL)
    private Autor autor;

    public Biografia() {
    }

    public Biografia(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getId() {
        return id;
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
                '}';
    }
}
