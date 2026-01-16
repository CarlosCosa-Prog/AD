package org.example.relaciones;

import jakarta.persistence.*;

import java.io.Serializable;


//HACEMOS EL INHERITANCE Y DISCRIMIATOR PORQUE ES UNA GENERALIZACIÓN CON LIBRO
@Entity
@Table(name = "contenidos digitales")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo",  discriminatorType = DiscriminatorType.STRING)
// FALTA DISCRIMINATOR VALUE
public class ContenidoDigital implements Serializable {


    //PONEMOS LA ID COMO CLAVE PRIMARIA PARA QUE NO SE REPITA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    protected String titulo;

    //EN ESTA ANOTACION MANYTOONE CREAMOS LA COLUMNA DE AUTOR ID Y SU CLASE Y ATRIBUTO.
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    //TAMBIÉN HE CREADO VARIOS CONSTRUCTORES AQUÍ
    public ContenidoDigital() {}

    public ContenidoDigital(String titulo) {
        this.titulo = titulo;
    }

    public ContenidoDigital(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }


    @Override
    public String toString() {
        return "ContenidoDigital{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                '}';
    }
}
