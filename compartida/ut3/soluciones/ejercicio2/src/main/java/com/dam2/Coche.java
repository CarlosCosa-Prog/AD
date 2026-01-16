package com.dam2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "coches")
public class Coche implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String matricula;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "coches_empls", joinColumns={@JoinColumn(name="id_coche")},
    inverseJoinColumns={@JoinColumn(name="id_empleado")})
    private List<Empleado> empleados;

    public Coche() {
    }

    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public Long getId() {
        return id;
    }

/*    public void setId(long id) {
        this.id = id;
    }*/

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' /*+
                ", empleados=" + empleados*/ +
                '}';
    }
}

