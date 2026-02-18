package org.example;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "contenidosdigitales")
public class ContenidoDigital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String titulo;
    @ManyToOne
    @JoinTable(name = "contenidos_id")  // HA DE SER "autor_id"
    private Autor autor;

    public ContenidoDigital() {
    }

    public ContenidoDigital(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
    }




    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
