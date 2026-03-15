package org.cosa.clases;

import jakarta.persistence.*;

@Entity
@Table(name = "biografias")
public class Biografia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    String texto;

    // Relacion 1 a 1 con Libro(clave compartida) (hijo)
    @OneToOne
    @MapsId
    @JoinColumn(name = "libro_id")
    private Libro libro;
}
