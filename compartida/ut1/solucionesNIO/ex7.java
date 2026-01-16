import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* Escribe un programa en Java que haga uso de NIO (New I/O) con canales y buffers para gestionar información de empleados.

 Se parte de un array de enteros que contiene, ordenados de la siguiente manera:

   * Primero todos los identificadores de los empleados.
   * Después, todas las horas trabajadas.
   * Finalmente, todas las tarifas por hora.

   Por ejemplo:

   { id1, id2, id3, horas1, horas2, horas3, tarifa1, tarifa2, tarifa3 }

2. El programa debe:
   a) Escribir este array en un fichero binario (emp.dat) utilizando un FileChannel y un ByteBuffer.
   b) Volver a leer el fichero con un ScatteringByteChannel, de manera que cada parte quede en un `ByteBuffer` distinto (uno para IDs, otro para horas y otro para tarifas).
   c) Calcular, para cada empleado, el sueldo correspondiente (horas * tarifa) y mostrarlo por pantalla.
   d) Escribir un segundo fichero (emp2.dat) con un GatheringByteChannel, que contenga para cada empleado su identificador y el sueldo correspondiente.

*/


public class ex7 {
    public static void main(String[] args) {
        final int TAM = 3;
        int array[] = {1,2,3,40,36,50,15,12,20};
        ByteBuffer bb = ByteBuffer.allocate(array.length * Integer.BYTES);
        IntBuffer ib = bb.asIntBuffer();
        ib.put(array);
        bb.position(ib.position() * Integer.BYTES);
        bb.flip();

        try(        RandomAccessFile raf = new RandomAccessFile("emp.dat","rw");
                    FileChannel fc = raf.getChannel();
                    RandomAccessFile raf2 = new RandomAccessFile("emp.dat","r");
                    ScatteringByteChannel sbc = raf2.getChannel();
                    RandomAccessFile raf3 = new RandomAccessFile("emp2.dat","rw");
                    GatheringByteChannel gbc = raf3.getChannel();
            )
        {
            fc.write(bb);

            ByteBuffer bb1 = ByteBuffer.allocate(3*Integer.BYTES);
            ByteBuffer bb2 = ByteBuffer.allocate(3*Integer.BYTES);
            ByteBuffer bb3 = ByteBuffer.allocate(3*Integer.BYTES);
            sbc.read(new ByteBuffer[]{bb1,bb2,bb3});
            bb1.flip(); bb2.flip(); bb3.flip();

            ByteBuffer bb4 = ByteBuffer.allocate(4*Integer.BYTES);
            //IntBuffer ib2 = bb4.asIntBuffer();
            while (bb1.hasRemaining()) {
                bb1.getInt();
                int n1 = bb2.getInt();
                int n2 = bb3.getInt();
                System.out.println("El trabajador " + n1 + " ha cobrado " + n1*n2 + " euros");

                bb4.putInt( n1 * n2);
                //bb4.position(ib2.position() * Integer.BYTES);
            }
            //ib2.flip();
            bb4.flip(); bb1.rewind();

            gbc.write(new ByteBuffer[]{bb1,bb4});


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

