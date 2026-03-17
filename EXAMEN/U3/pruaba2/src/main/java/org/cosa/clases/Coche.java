package org.cosa.clases;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coches")
public class Coche implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String matricula;
    @Column
    private String modelo;
    //Relacion N a N con Empleado
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "empleado_coche",
            joinColumns = {@JoinColumn(name = "coche_id")},
            inverseJoinColumns = {@JoinColumn(name = "empleado_id")})
    private List<Empleado> empleados;

    public Coche() {
        empleados = new ArrayList<>();
    }

    public Coche(String matricula, String modelo, List<Empleado> empleados) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.empleados = empleados;
    }

    public Long getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", modelo='" + modelo + '\'' +
                ", empleados=" + empleados +
                '}';
    }
}
