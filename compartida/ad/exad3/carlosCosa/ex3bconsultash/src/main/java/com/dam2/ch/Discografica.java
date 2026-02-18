package com.dam2.ch;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "discograficas")
public class Discografica implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nom;
    @Column
    private String direccion;
    @OneToMany(mappedBy = "discografica", cascade = CascadeType.PERSIST)
    private List<Disco> discos;
    public Discografica() {
    }

    public Discografica(String nom, String direccion) {
        this.nom = nom;
        this.direccion = direccion;
        discos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Disco> getDiscos() {
        return discos;
    }

    public void setDiscos(List<Disco> tlfs) {
        this.discos = tlfs;
    }

    @Override
    public String toString() {
        return "Discografica{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", direccion='" + direccion + '\'' +
                ", discos=" + discos +
                '}';
    }
}
