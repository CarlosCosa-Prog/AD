package com.dam2.ejercicio1;

import jakarta.persistence.*;

@Entity
@Table(name ="biografias")
public class Biografia implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String memo;
    @OneToOne
    @JoinColumn(name = "autorId")
    private Autor autor;

    public Biografia() {
    }

    public Biografia(String memo) {
        this.memo = memo;
    }

    public long getId() {
        return id;
    }

 /*   public void setId(long id) {
        this.id = id;
    }*/

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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
                ", memo='" + memo + '\'' +
                //", autor=" + autor +
                '}';
    }
}
