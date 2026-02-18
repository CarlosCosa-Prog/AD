package org.example;

import jakarta.persistence.*;

@Entity
@Table(name="biografias")
public class Biografia {

    @Id
    //@OneToOne
    @MapsId
    //@JoinColumn(name = "autor_id");
    Long id;

    @Column
    String texto;

    public Biografia() {}

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
                '}';
    }
}
