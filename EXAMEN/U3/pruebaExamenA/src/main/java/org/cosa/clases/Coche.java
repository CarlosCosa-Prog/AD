package org.cosa.clases;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("coche")
public class Coche extends Auto{
    @Column
    int potencia;
}
