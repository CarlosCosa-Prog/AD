package org.example.relaciones;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Map;

@Entity
@Table(name = "biografias")

public class Biografia implements Serializable {

    //EN ESTE CASO QUITAMOS EL GENERATED YA QUE TIENE CLAVE COMPARTIDA
    @Id
    private Long id;

    @Column(name = "texto")
    private String text;

    //AQUÍ PARA QUE LA CLAVE COMPARTIDA SEA EFECTIVA, PONEMOS LA ANOTACION MAPSID
    @OneToOne
    @MapsId
    @JoinColumn(name = "autor_id")
    private Autor autor;

    //HE CREADO VARIOS CONSTRUCTORES A PARTE DEL DE SIN PARAMETROS
    public Biografia() {}

    public Biografia(String text) {
        this.text = text;
    }

    public Biografia(String text, Autor autor) {
        this.text = text;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
                ", text='" + text + '\'' +
                ", autor=" + autor +
                '}';
    }
}
