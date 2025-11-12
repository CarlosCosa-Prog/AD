package com.dam2;

public interface EmpleadoDAO {
    public void insert(Empleado empleado);
    public void update(Empleado empleado);
    public void delete(Integer id);
    public Empleado read(Integer id);
}
