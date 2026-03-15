package clases;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String nombre;
    @Column
    int añoNacimiento;

    // relacion 1 a 1 con biografia
    @OneToOne(mappedBy = "autor",cascade = CascadeType.PERSIST)
    private Biografia biografia;
}
