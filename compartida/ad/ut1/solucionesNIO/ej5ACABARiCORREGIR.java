//5. Crea 2 IntBuffers con capacidad para 10 enteros cada uno de ellos.
// Guarda, de entre los 20 primeros números naturales, los pares en uno y los impares en otro.
// Escribe el contenido de ambos búferes a un fichero "numeros.dat".
// Lee el contenido del fichero con un ScatteringByteChannel que reparta el contenido en 4 búferes de igual tamaño.
// Reune el contenido del primer y tercer buffer en un nuevo fichero con GatheringByteChannel.

import java.nio.channels.ScatteringByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class ej5
{
    public static <sbc> void main(String[] args)
    {
        ByteBuffer pares = ByteBuffer.allocate(40);
        ByteBuffer impares = ByteBuffer.allocate(40);

        //escribir numeros pares e impares del 1 al 20 en sus respectivos buffers
        for (int i = 1; i <= 20; i++)
        {
            if (i%2 == 0)
                pares.putInt(i);
            else
                impares.putInt(i);
        }

        try(FileChannel fc = FileChannel.open(Paths.get("numeros.dat"), StandardOpenOption.CREATE,StandardOpenOption.WRITE);
            ScatteringByteChannel sbc = FileChannel.open(Paths.get("numeros.dat")))
        {
            pares.flip();
            impares.flip();

            fc.write(pares);
            fc.write(impares);

            System.out.println("COMPLETADO");

            pares.clear();
            impares.clear();

            sbc.read(new ByteBuffer[] {pares,impares});

            pares.flip();
            impares.flip();

            System.out.println("IMPRIMIR BYTEBUFFER 1");
            while (impares.hasRemaining())
            {
                System.out.println(impares.getInt());
            }

            System.out.println("IMPRIMIR BYTEBUFFER 2");
            while (pares.hasRemaining())
            {
                System.out.println(pares.getInt());
            }
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
