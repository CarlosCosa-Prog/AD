package org.cosa.clases;

import jakarta.persistence.*;

@Entity
@Table(name = "carnets")
public class CarnetConducir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    String tipo;

    // Relacion 1 a 1 con Propietario(clave compartida)
    @OneToOne
    @MapsId
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;
}
