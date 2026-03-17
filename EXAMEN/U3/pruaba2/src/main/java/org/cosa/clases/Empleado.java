package org.cosa.clases;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="empleados")
@DiscriminatorValue("empleado")
public class Empleado extends Persona{
    @Column
    private double salario;

    //Relacion 1 a 1 con Email
    @OneToOne(mappedBy = "empleados", cascade = CascadeType.PERSIST)
    private Email email;

    // Relacion 1 a 1 con Despacho (unidireccional)
    @OneToOne
    private Despacho despacho;

    // Relación 1 a 1 con usuario (bidireccional)
    @OneToOne(mappedBy = "empleados",cascade = CascadeType.PERSIST)
    private Usuario usuario;

    // Relacion N a N con Coche
    @ManyToMany(mappedBy = "empleados",cascade = CascadeType.PERSIST)
    private List<Coche> coches;

    // Relacion 1 a N con Departamento (Empleado es N)
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    public Empleado() {
        coches = new ArrayList<>();
    }

    public Empleado(String nombre, double salario) {
        super(nombre);
        this.salario = salario;
    }

    public Empleado(String nombre, double salario, Email email, Despacho despacho, Usuario usuario, List<Coche> coches, Departamento departamento) {
        super(nombre);
        this.salario = salario;
        this.email = email;
        this.despacho = despacho;
        this.usuario = usuario;
        this.coches = coches;
        this.departamento = departamento;
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

    @Override
    public String toString() {
        return "Empleado{" +
                "salario=" + salario +
                ", email=" + email +
                ", despacho=" + despacho +
                ", usuario=" + usuario +
                ", coches=" + coches +
                ", departamento=" + departamento +
                '}';
    }
}
