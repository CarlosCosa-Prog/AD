package org.pcg;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
//Le digo a la base de datos que le ponga propietarios en minúscula a la tabla
@Table(name="propietarios")
public class Propietario implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    // Lista de coches que puede tener un propietario
    @ManyToOne()    // ES AL CONTRARIO: ONE TO MANY
    private List<Auto> coches;

    public Propietario() {
    }
    public Propietario(String nombre) {
        this.nombre = nombre;
        coches = new ArrayList<Auto>();
    }
    public Propietario(String nombre, List<Auto> coches) {
        this.nombre = nombre;
        this.coches = coches;
    }

    public Long getId() {
        return id;
    }
    //El setter no lo voy a usar nunca
    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Auto> getCoches() {
        return coches;
    }

    public void setCoches(List<Auto> coches) {
        this.coches = coches;
    }
}
