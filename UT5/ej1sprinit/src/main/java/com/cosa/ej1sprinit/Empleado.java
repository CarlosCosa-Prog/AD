package com.cosa.ej1sprinit;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@NoArgsConstructor  // constructor vacio (3)
@AllArgsConstructor
@Data
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable { // implements serializable (1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // Long id(1)

    @Column(name = "nombre")
    private String nom;
    @Column
    private double salario;


}
