package clases;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bibliotecas")
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String localidad;

    // Relacion N a M entre biblioteca y libro
    @ManyToMany(mappedBy = "bibliotecas")
    private List<Libro> libros;
}
