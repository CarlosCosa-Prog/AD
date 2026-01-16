package org.example;

import java.sql.SQLException;

import static org.example.conexion.probarConexion;
import static org.example.ejercicio.transferencia;

public class principal {
    public static void main(String[] args) {
        probarConexion();
        transferencia();
    }
}
/* Preguntas teoría:
*   5. El patron DAO consiste en separar las funciones mas importantes por secciones.
*   Esto mejora la eficiencia del programa, en java se utiliza la clase PreparedStatment para establecer
*   statments con valores preestablecidos, es decir que puedes llamar a la funcion y pasarle los valores
*   para que se ejecute directamente.
*
*   6.  mark()--> establece la marca del buffer en su posicion
        reset()--> vuelve a la marca establecida previamente con mark
        clear() --> limpia el buffer, el limite se establece a 0 y la marca se descarta
        flip() --> el limite se establece en la posicion actual y la posición en cero
        rewind() --> la posicion se establece en cero y la marca se decarta
* */
