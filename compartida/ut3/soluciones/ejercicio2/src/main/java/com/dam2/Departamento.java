package com.dam2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departamentos")
public class Departamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nom;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "departamento")
    private List<Empleado> empleados;

    public Departamento() {
    }

    public Departamento(String nom) {
        this.nom = nom;
        empleados = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Long getId() {
        return id;
    }

 /*   public void setId(long id) {
        this.id = id;
    }*/

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nom='" + nom + '\'' /*+
                ", empleados=" + empleados */+
                '}';
    }
}
