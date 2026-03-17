package org.cosa.clases;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String contraseña;

    // Relacion 1 a 1 con Empleado (bidireccional)
    @OneToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    public Usuario() {
    }

    public Usuario(String nombre, String contraseña, Empleado empleado) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.empleado = empleado;
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", empleado=" + empleado +
                '}';
    }
}
