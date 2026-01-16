package com.dam2.ej2relaciones;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// 1. Anotación entidad
@Entity
// 2. Anotación tabla con nombre
@Table(name = "empresas")
// 3. Creación de la entidad respetando Singleton (serializable, constructo(), Long id)
public class Empresa implements Serializable {
    // Creación del id (autocompletado)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Es necesario poner el @Column para los atributos que quieres que sean columnas
    @Column(name = "nombre")
    private String nombre;
    // RELACION
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.PERSIST)
    private List<Empleado> empleados;
    // relacion con inversor
    @ManyToMany(mappedBy = "empresas", cascade = CascadeType.PERSIST)
    private List<Inversor> inversores;

    // Creación de los constructores, setters, getters y toString (Clic derecho > Generete) (Alt + Insert)
    public Empresa() {}

    public Empresa(String nombre) {
        this.nombre = nombre;
        empleados = new ArrayList<>();
        inversores = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }
    // Se elimina el setId ya que no debe poder modificarse la clave primaria
    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // RELACION
    // Constructor, getter y setter del empleado
    public Empresa(String nombre, List<Empleado> empleados) {
        this.nombre = nombre;
        this.empleados = empleados;
        inversores = new ArrayList<>(); // esto obliga a hacer despues un setInversor pero permite establecer un inversor sin ninguna empresa
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Inversor> getInversores() {
        return inversores;
    }

    public void setInversores(List<Inversor> inversores) {
        this.inversores = inversores;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
