package com.dam2.ejercicio1;

import jakarta.persistence.*;

@Entity
@Table(name ="autores")
public class Autor implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre")
    private String nom;
    @Column(name = "añoNacimiento")
    private int yearBirth;
    @OneToOne(mappedBy = "autor",cascade = CascadeType.PERSIST)
    private Biografia biografia;

    public Autor() {
    }

    public Autor(String nom, int yearBirth) {
        this.nom = nom;
        this.yearBirth = yearBirth;
    }

    public long getId() {
        return id;
    }

 /*   public void setId(long id) {
        this.id = id;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public Biografia getBiografia() {
        return biografia;
    }

    public void setBiografia(Biografia biografia) {
        this.biografia = biografia;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", yearBirth=" + yearBirth +
                ", biografia=" + biografia +
                '}';
    }
}
