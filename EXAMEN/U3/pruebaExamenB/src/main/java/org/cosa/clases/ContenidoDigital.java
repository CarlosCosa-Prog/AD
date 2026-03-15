package org.cosa.clases;

import jakarta.persistence.*;

@Entity
@Table(name="contenidos")
// Relacion de herencia con libro
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_contenido")
@DiscriminatorValue("contenido")
public class ContenidoDigital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;

    // Relacion 1 a N con Autor(ContenidoDigital es N)
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
}
