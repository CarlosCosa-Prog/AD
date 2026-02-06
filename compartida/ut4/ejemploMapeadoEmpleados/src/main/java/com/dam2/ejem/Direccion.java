package com.dam2.ejem;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;


public class Direccion {
 //  El ID sólo lo ponemos en el documento raíz de la colección.
    //@BsonProperty(value = "tipo_via")
    private String tipoVia;
    private String nombre;
    private Integer num;

    public Direccion() {
    }

    public Direccion(String tipoVia, String nombre, int num) {
        this.tipoVia = tipoVia;
        this.nombre = nombre;
        this.num = num;
    }

    public String getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Direccion: {" +
                "tipoVia='" + tipoVia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", num=" + num +
                '}';
    }
}
