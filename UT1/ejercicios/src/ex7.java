/*
* 7. Programa que haga uso de canales y buffers para gestionar información de empleados.

 Se parte de un array de enteros que contiene, ordenados de la siguiente manera:

   * Primero todos los identificadores de los empleados.
   * Después, todas las horas trabajadas.
   * Finalmente, todas las tarifas por hora.

   Por ejemplo:

   { id1, id2, id3, horas1, horas2, horas3, tarifa1, tarifa2, tarifa3 }

	El programa debe:
   a) Escribir este array en un fichero binario (emp.dat) utilizando un FileChannel y un ByteBuffer.
   b) Volver a leer el fichero con un ScatteringByteChannel, de manera que cada parte quede en un `ByteBuffer` distinto
   * (uno para IDs, otro para horas y otro para tarifas).
   c) Calcular, para cada empleado, el sueldo correspondiente (horas * tarifa) y mostrarlo por pantalla.
   d) Escribir un segundo fichero (emp2.dat) con un GatheringByteChannel, que contenga para cada empleado su
   * identificador y el sueldo correspondiente.
   */
public class ex7 {
}
