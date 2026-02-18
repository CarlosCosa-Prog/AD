package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "biografias")
public class Biografia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String texto;
    @OneToOne
    @MapsId
    @JoinColumn(name = "biografia") // HA DE SER AUTOR_ID
    private Autor autor;

    public Biografia() {
    }

    public Biografia(String texto, Autor autor) {
        this.texto = texto;
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Long getId() {
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
                ", autor=" + autor +
                '}';
    }
}
