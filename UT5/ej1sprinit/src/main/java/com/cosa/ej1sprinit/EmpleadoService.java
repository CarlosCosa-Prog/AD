package com.cosa.ej1sprinit;

import java.util.List;
import java.util.Optional;


public interface EmpleadoService {
    // Optional para evitar el nullPointerException si no existe el id
    Optional<Empleado> findById(Long id);
    List<Empleado> findAll();
    void saveEmpleado(Empleado empleado);
    Empleado updateEmpleado(Long id, Empleado empleado);
    void deleteEmpleado(Long id);
}