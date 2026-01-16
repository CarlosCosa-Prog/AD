package com.dam2.ej2relaciones;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "empleados")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_empleado", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Empl")

public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id; // cambio a protected porque es una clase base y las derivadas deberían poder acceder al atributo
    @Column(name ="nombre")
    protected String nom;
    @Column
    protected double salario;

    // RELACIONES
    // Creación del atributo empresa para la relación
    // Para la relación se pone primero la que es de esta clase
    @ManyToOne  // Una empresa tiene 1 o muchos empleados
    // Foreign Key se pone en la relación de muchos
    @JoinColumn(name = "id_empresa")
    protected Empresa empresa;

    // Relacion: Empleado - Deporte (N a 1, unidir)
    // no es neceario poner el @column
    @ManyToOne(cascade = CascadeType.PERSIST)
    protected Deporte deporte;

    @OneToOne(mappedBy = "empleado",  cascade = CascadeType.PERSIST)
    protected Usuario usuario;

    // Nuevos constructores, setters y getters con Empresa
    public Empleado(String nom, double salario, Empresa empresa) {
        this.nom = nom;
        this.salario = salario;
        this.empresa = empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empleado() {
    }

    public Empleado(String nom, double salario) {
        this.nom = nom;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

  /*public void setId(long id) {
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

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", salario=" + salario +
                ", empresa=" + empresa +
                '}';
    }
}
