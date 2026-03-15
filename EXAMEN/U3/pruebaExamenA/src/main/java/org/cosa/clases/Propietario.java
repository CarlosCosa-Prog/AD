package org.cosa.clases;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "propietarios")
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;

    // Relación 1 a N con Auto(Propietario es 1)
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.PERSIST)
    private List<Auto> autos;

    // Relacion 1 a 1 con CarnetConducir (clave compartida)
    @OneToOne(mappedBy = "propietario",cascade = CascadeType.PERSIST)
    private CarnetConducir carnetConducir;

}
