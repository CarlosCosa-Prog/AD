package com.cosa.ejemploSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public Optional<Pelicula> findById(Long id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public List<Pelicula> findALl() {
        return (List<Pelicula>) peliculaRepository.findAll();
    }

    @Override
    public void saveAll(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula updatePelicula(Long id, Pelicula pelicula) {
        // 1. Objeto pelicula con los datos de la pelicula antes de modificarlo
        Pelicula viejo = peliculaRepository.findById(id).get();

        // 2. Declarar variables con el contenido de cada campo
        String titulo = pelicula.getTitulo();
        String director = pelicula.getDirector();
        int año = pelicula.getAño();

        // 3. Comprobar si algún campo está vacío
        if ((titulo != null) && !(titulo.isEmpty())){
            viejo.setTitulo(titulo);
        }

        if ((director != null) && !(director.isEmpty())){
            viejo.setDirector(director);
        }

        if (Objects.nonNull(año)){
            viejo.setAño(año);
        }

        // 4. Guardar la pelicula vieja ya modificada
        peliculaRepository.save(viejo);

        // 5. Devolver la pelicula vieja
        return viejo;
    }

    @Override
    public void deletePelicula(Long id) {
        peliculaRepository.deleteById(id);
    }
}
