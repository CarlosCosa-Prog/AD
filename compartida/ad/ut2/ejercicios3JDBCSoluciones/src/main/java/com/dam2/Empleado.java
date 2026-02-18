package com.dam2;

public class Empleado {
    private int id;
    private String nombre;
    private String apellido;
    private double salario;
    private int dptmtId;

    public Empleado(String nombre, String apellido, double salario, int dptmtId) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.dptmtId = dptmtId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getDptmtId() {
        return dptmtId;
    }

    public void setDptmtId(int dptmtId) {
        this.dptmtId = dptmtId;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", salario=" + salario +
                ", dptmtId=" + dptmtId +
                '}';
    }
}
