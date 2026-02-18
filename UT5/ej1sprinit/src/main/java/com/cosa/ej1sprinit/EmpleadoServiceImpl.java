package com.cosa.ej1sprinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service    // 1. Implementar el @Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired  // 2. Implementar el @Autowired
    private EmpleadoRepository empleadoRepository;

    // lo autocompleta
    @Override
    public Optional<Empleado> findById(Long id) {
        return empleadoRepository.findById(id); // utilizar el método que hemos creado en el service
    }
    // con el autocompletado hay que dejar el puntero en findAll(escribirlo) > castExpression
    @Override
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadoRepository.findAll();
    }

    // lo autocompleta
    @Override
    public void saveEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public Empleado updateEmpleado(Long id, Empleado empleado){
        // objeto empleado con los datos del empleado antes de modificarlo
        Empleado viejo =  empleadoRepository.findById(id).get();
        String nombre = viejo.getNom(); // facilitar usar el getNom más de una vez
        double salario = viejo.getSalario(); // facilitar usar el getSalario más de una vez

        // Si el getNom es distinto de null o NO está vacío.
        if ((nombre != null) && !(nombre.isEmpty()))
            viejo.setNom(nombre);

        // Si el salario no está vacio
        if (Objects.nonNull(salario))
            viejo.setSalario(salario);

        // Una vez modificado lo vuelvo a guardar en el repositorio
        empleadoRepository.save(viejo);
        return viejo;
    }

    // lo autocompleta
    @Override
    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }

}
