package org.cosa.clases;

import jakarta.persistence.*;

@Entity
@Table(name="autos")
// Relacion de herencia con Coche
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_auto")
@DiscriminatorValue("auto")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String matricula;

    // Relacion 1 a N con Propietario(Auto es N)
    @ManyToOne()
    @JoinColumn(name = "propietario_id") // fk
    private Propietario propietario;

}
