package com.dam2;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo",discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue(value = "P")
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String nom;

    public Persona() {
    }

    public Persona(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

/*    public void setId(long id) {
        this.id = id;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
