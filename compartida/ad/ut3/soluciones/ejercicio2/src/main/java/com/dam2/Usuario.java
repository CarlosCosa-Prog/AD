package com.dam2;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String passw;
    @OneToOne
    @JoinColumn(name = "empleadoId")
    private Empleado empleado;

    public Usuario() {
    }

    public Usuario(String nom, String passw) {
        this.nom = nom;
        this.passw = passw;
    }

    public Long getId() {
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

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", passw='" + passw + '\'' +
                ", empleado=" + empleado +
                '}';
    }
}
