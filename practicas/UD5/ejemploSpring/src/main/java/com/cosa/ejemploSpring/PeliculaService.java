package com.cosa.ejemploSpring;

import java.util.List;
import java.util.Optional;

public interface PeliculaService {
    Optional <Pelicula> findById (Long id);
    List<Pelicula> findALl();
    void saveAll(Pelicula pelicula);
    Pelicula updatePelicula(Long id, Pelicula pelicula);
    void deletePelicula(Long id);
}
