package com.dam2;

import org.springframework.data.annotation.Id;

import java.util.List;

//@Document
public class Disco {
    //@BsonId
    @Id // no es ObjectId
    //@MongoId(FieldType.INT32)
    private int id;
    private String titulo;
    private List<String> musicos;
    private String discografica;
    private double precio;

    public Disco() {
    }

    public Disco(int id, String titulo, List<String> musicos, String discografica, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.musicos = musicos;
        this.discografica = discografica;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getMusicos() {
        return musicos;
    }

    public void setMusicos(List<String> musicos) {
        this.musicos = musicos;
    }

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Disco{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", musicos=" + musicos +
                ", discografica='" + discografica + '\'' +
                ", precio=" + precio +
                '}';
    }
}
