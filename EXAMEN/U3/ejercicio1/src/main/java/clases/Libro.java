package clases;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    int isbn;

    // Relacion N a M entre Libro y Autor (un libro tiene una lista de Autores)
    @ManyToMany
    @JoinTable(
            name = "libro_autor",   // nombre de la tabla intermedia
            joinColumns = @JoinColumn(name="libro_id"),  // clave que apunta a la tabla donde estás
            inverseJoinColumns = @JoinColumn(name="autor_id")   // clave que apunta a la otra tabla
    )
    private List<Autor> autores;    // lista de autores

    // Relación N a M entre Libro y Biografia
    @ManyToMany
    @JoinTable(
            name = "libro_biblioteca",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "biblioteca_id")
    )
    private List<Biblioteca> bibliotecas;

    // Relacion 1 a M entre Libro y Editorial (Libro es el N)
    @ManyToOne
    @JoinColumn(name = "editorial_id") // FK
    private Editorial editorial;
}
