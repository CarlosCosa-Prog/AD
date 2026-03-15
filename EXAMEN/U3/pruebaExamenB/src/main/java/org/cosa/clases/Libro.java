package org.cosa.clases;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@DiscriminatorValue("libro")
public class Libro extends ContenidoDigital{
    @Id
    private Long id;
    @Column
    private int isbn;
}
