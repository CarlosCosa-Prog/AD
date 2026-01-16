package org.example.relaciones;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity //DATTA
@DiscriminatorValue(value = "libro")
public class Libro extends ContenidoDigital{

    //NO PONEMOS EL ID PORQUE LO HEREDA DE LA CLASE CONTENIDODIGITAL
    @Column
    private String isbn;

    //LE HE PUESTO VARIOS CONSTRUCTORES A PARTE DEL DE SIN PARAMETROS PARA PODER CREAR BIEN LOS OBJETOS
    public Libro(){}

    public Libro(String titulo, String isbn){
        super(titulo);
        this.isbn = isbn;
    }

    //PODEMOS METER A AUTOR AQUÍ DEBIDO A QUE LO HEREDA
    public Libro(String titulo, Autor autor, String isbn){
        super(titulo,autor);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
