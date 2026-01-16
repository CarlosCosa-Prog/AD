package com.dam2.ej2relaciones;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inversores")
public class Inversor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @ManyToMany
    @JoinTable(name = "empresas_inversores",    // nombre de la tabla
            joinColumns = @JoinColumn(name = "id_inversor"), // clase en la que te encuentras
            inverseJoinColumns = @JoinColumn(name = "id_empresa")) // clase a la que te conectas
    private List<Empresa> empresas;

    public Inversor() {
    }

    public Inversor(String nombre, List<Empresa> empresas) {
        this.nombre = nombre;
        this.empresas = empresas;
    }

    public Inversor(String nombre) {
        this.nombre = nombre;
        empresas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    @Override
    public String toString() {
        return "Inversor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", empresas=" + empresas +
                '}';
    }
}
