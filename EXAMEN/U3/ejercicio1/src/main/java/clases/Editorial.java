package clases;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "editoriales")
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String nombre;

    // Relacion 1 a N entre Libro y Editorial (Editorial es 1)
    @OneToMany(mappedBy = "editorial", cascade = CascadeType.PERSIST)
    private List<Libro> libros;
}
