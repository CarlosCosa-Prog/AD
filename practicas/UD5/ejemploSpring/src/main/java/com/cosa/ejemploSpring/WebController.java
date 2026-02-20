package com.cosa.ejemploSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WebController {
    @Autowired
    private PeliculaServiceImpl psi;

    // curl -X GET localhost:8080/lista
    // Devolver todas las peliculas
    @GetMapping("/lista")
    public List<Pelicula> listaTodos(){
        return psi.findALl();
    }

    // curl -X GET localhost:8080/lista/2
    // Devolver un peliculas según su id
    @GetMapping("/lista/{id}")
    public Optional<Pelicula> listaPorId(@PathVariable Long id){
        return psi.findById(id);
    }

    // curl -X POST localhost:8080/alta -d '{"titulo":"DJango Desencadenado", "director":"Quentin Tarantino", "año": 2012}' -H "Content-Type: application/json"
    // Insertar una nueva pelicula
    @PostMapping("/alta")
    public void alta(@RequestBody Pelicula pelicula){
        psi.saveAll(pelicula);
    }

    // curl -X PUT localhost:8080/modifica/2 -d '{"titulo": "Kil Bill", "director":"Quentin Tarantino", "año":2000}' -H "Content-Type: application/json"
    // Actualizar una pelicula a partir de su id
    @PutMapping("/modifica/{id}")
    public Pelicula modifica(@PathVariable Long id, @RequestBody Pelicula pelicula){
        return psi.updatePelicula(id, pelicula);
    }

    // curl -X DELETE localhost:8080/borra/2
    // Borrar una pelicula a partir de su id
    @DeleteMapping("/borra/{id}")
    public void borra(@PathVariable Long id){
        psi.deletePelicula(id);
    }
}
