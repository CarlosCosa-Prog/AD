package org.cosa.clases;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "emails")
public class Email implements Serializable {
    @Id
    private Long id;
    @Column
    private String direccion;

    // Relacion 1 a 1 con Empleado (clave compartida)
    @OneToOne
    @MapsId
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    public Email() {
    }

    public Email(String direccion, Empleado empleado) {
        this.direccion = direccion;
        this.empleado = empleado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", empleado=" + empleado +
                '}';
    }
}
