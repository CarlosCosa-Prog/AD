package org.dam2.PSP;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros") // NO DEBE HABER TABLA LIBROS: HA DE SER LA MISMA DE CONTENIDOS DIGITALES
@DiscriminatorValue("libro")
public class Libro extends ContenidoDigital{
    private int isbn;

    public Libro() {
    }

    public Libro(int isbn) {
        this.isbn = isbn;
    }

    public Libro(int id, String titulo, int isbn) {
        super(id, titulo);
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
}
