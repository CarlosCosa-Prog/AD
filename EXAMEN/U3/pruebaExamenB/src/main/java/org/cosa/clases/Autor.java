package org.cosa.clases;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;

    // Relacion 1 a N con ContenidoDigital (Autor es 1)
    @OneToMany(mappedBy = "autor",cascade = CascadeType.PERSIST)
    private List<ContenidoDigital> contenidosDigitales;

    // Relacion 1 a 1 con Biografia (clave compartida) (padre)
    @OneToOne(mappedBy = "autor",cascade = CascadeType.PERSIST)
    private Biografia biografia;

}
