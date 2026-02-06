package com.dam2.ejem;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;


public class Empleado {
    @BsonId
    // en MongoDB es _id, pero el atributo en la clase es id
    private ObjectId id;
    //@BsonProperty(value = "nom")
    private String nombre;
    private List<Direccion> dirs;

    public Empleado() {
        dirs = new ArrayList<Direccion>();
    }

    public Empleado(String nombre)
    {
        this.nombre = nombre;
        dirs = new ArrayList<Direccion>();
    }
    public Empleado(String nombre, List<Direccion> dirs) {
        this.nombre = nombre;
        dirs = this.dirs;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

        // SI CAMBIO EL NOMBRE DEL MÉTODO A getDir EL MAPEADO FALLA
    public List<Direccion> getDirs() {
        return dirs;
    }

    public void setDirs(List<Direccion> dirs) {
        this.dirs = dirs;
    }

    public void addDir(Direccion dir)
    {
        dirs.add(dir);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "_id=" + id.toString() +
                ", nombre='" + nombre + '\'' +
                ", direcciones=" + dirs +
                '}';
    }
}
