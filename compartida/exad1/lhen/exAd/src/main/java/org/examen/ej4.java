package org.examen;

public class ej4 {
    public static void main(String[] args) {}
}

/* ---- PREGUNTAS TEORÍA ----
 -- 7. Exlica la diferencia entre los búferes directos y no directos.
    Indica cuáles hemos utilizado en clase.
    La diferencia consiste en que los búferes directos tienen mayor coste de memoria que
    los indirectos, además de que estos pueden no apoyarse en búferes intermedios a la
    hora de llevar a cabo operaciones E/S, cosa que los indirectos sí. Un búfer directo
    se puede crear directamente a partir de un archivo, cosa que un indirecto no.
    En clase usamos siempre los directos.

    -- 6. Cita y explica los 4 parámetros útiles para trabajar con las distintas
    posiciones en los búferes NIO.
    Los elementos clave son: el límite del buffer, su capacidad, la marca y la posición.
    - Límite: inidica el límite del buffer al que podremos acceder. Puede ser menor o
      igual que la capacidad, pero nunca mayor.
    - Marca: es una posición específica guardada que se puede utilizar para cambiar la
      posición del buffer con más facilidad si fuese necesario. Se guarda con el metodo
      mark(). Ejemplo: bb.mark();
    - Capacidad: cantidad de bytes totales que puede alojar el buffer.
    - Posición: punto del buffer en el que nos encontramo mientras trabajamos con él.
*/
