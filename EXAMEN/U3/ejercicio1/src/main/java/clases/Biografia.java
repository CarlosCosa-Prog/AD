package clases;

import jakarta.persistence.*;

@Entity
@Table(name = "biografias")
public class Biografia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String descpripcion;

    // relación 1 a 1 con autor (la biografia no puede existir sin el autor)
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autor_id") // FK
    private Autor autor;
    /*Si fuera con clave compartida (Habría que quitar el GeneratedValue)
    * @OneToOne
    * @MapsId
    * @JoinColumn
    * private Autor autor*/

}
