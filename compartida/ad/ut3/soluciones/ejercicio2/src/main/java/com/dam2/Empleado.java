package com.dam2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
//@Table(name="empleados")
@DiscriminatorValue(value = "E")
public class Empleado extends Persona {

    private double salario;
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "empleado")
    //@PrimaryKeyJoinColumn(name = "correo",referencedColumnName = "id")
    private Email email;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Despacho despacho;
    @OneToOne(mappedBy = "empleado",cascade = CascadeType.PERSIST)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "departamentoId")
    private Departamento departamento;
    @ManyToMany(mappedBy = "empleados", cascade = CascadeType.PERSIST)
    private List<Coche> coches;

    public Empleado() {
    }

    public Empleado(String nom, double salario, Email email, Despacho despacho, Usuario usuario, Departamento departamento, List<Coche> coches) {
        super(nom);
        this.salario = salario;
        this.email = email;
        this.despacho = despacho;
        this.usuario = usuario;
        this.departamento = departamento;
        this.coches = coches;
    }

    public Empleado(String nom, double salario) {
        this.nom = nom;
        this.salario = salario;
        this.email = email;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Despacho getDespacho() {
        return despacho;
    }

    public void setDespacho(Despacho despacho) {
        this.despacho = despacho;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

   /* public void setId(long id) {
        this.id = id;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", salario=" + salario +
                ", email=" + email +
                ", despacho=" + despacho +
                ", usuario=" + usuario +
                ", departamento=" + departamento +
                ", coches=" + coches +
                '}';
    }
}
