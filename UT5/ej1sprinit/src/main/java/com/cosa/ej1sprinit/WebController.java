package com.cosa.ej1sprinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*@Controller
@ResponseBody*/
@RestController
public class WebController {
    @Autowired
    private EmpleadoServiceImpl esi;

    // se puede saber que devuelve cada una de las funciones pasando el puntero por encima una vez escrita
    // por ejemplo findAll se ve public List<Empleado> por lo que tiene que devolver lo mismo

    //@RequestMapping(method = RequestMethod.GET, value =/lista)
    //@GetMapping(value = "/lista")
    // devolver todos los empleados
    //  curl -X GET localhost:8080/lista
    @GetMapping("/lista")
    public List<Empleado> listaTodos() {
        return esi.findAll();
    }

    // devolver un solo empleado a partir del id
    //  curl -X GET localhost:8080/lista/1
    @GetMapping("/lista/{id}")
    // tiene que ser optional para evitar el NullPointerException
    // @PathVariable indica que la variable Long id la recibe a partir del url
    public Optional<Empleado> listaPorId(@PathVariable Long id) {
        return esi.findById(id);
    }

    // añadir un nuevo empleado (lo autocompleta)
    // @RequestBody indica que la variable de empleado la recibe a partir del cuerpo de la petición
    //@RequestMapping(method = RequestMethod.POST)
    // curl -X POST localhost:8080/alta -d '{"nom":"Pepe perez","salario":2222}' -H "Content-Type: application/json"
    @PostMapping("/alta")
    public void alta(@RequestBody Empleado empleado) {
        esi.saveEmpleado(empleado);
    }

    // modificar un empleado a partir de su id (lo autocompleta)
    //@RequestMapping(method = RequestMethod.PUT)
    // Devuelve un objeto de tipo Empleado (igual que la función updateEmpleado)
    //  curl -X PUT localhost:8080/modifica/1 -d '{"nom":"Bad Bunny","salario":10}' -H "Content-Type: application/json"
    @PutMapping("/modifica/{id}")
    public Empleado modifica(@PathVariable Long id, @RequestBody Empleado empleado) {
        return esi.updateEmpleado(id, empleado);
    }

    // borrar un empleado a partir de su id (lo autocompleta)
    //@RequestMapping(method = RequestMethod.DELETE)
    //  curl -X DELETE localhost:8080/baja/1
    @DeleteMapping("/baja/{id}")
    public void baja(@PathVariable Long id) {
        esi.deleteEmpleado(id);
    }

}
