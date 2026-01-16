import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* Programa con java.nio que partiendo de un array estático de enteros con los 100 primeros números naturales (de 1 a 100)
 genere un buffer con esos valores y escriba éste a un fichero "nums.dat".
 Después el programa ha de hacer un "Scattering and gathering": leer de nums.dat y separar en 2 buffers nuevos los primeros
 50 números y los 50 últimos. A partir de estos 2 últimos buffers, reunir todos los valores del segundo seguidos de
 los valores del primer buffer en un nuevo fichero "nums2.dat".
 */
public class ex6 {
    private static final int TAM = 100;
    public static void main(String[] args) {
        int array[] = new int[TAM];

        for (int i = 0; i < TAM; i++)
            array[i] = i+1;

        //ByteBuffer bb1 = ByteBuffer.wrap(array);
        ByteBuffer bb = ByteBuffer.allocate(TAM * Integer.BYTES);
        //bb.clear();
        IntBuffer ib = bb.asIntBuffer();
        ib.put(array);

        bb.position(ib.position() * Integer.BYTES); // avança posició de bb
        bb.flip();
        ib.flip();

        try {
            RandomAccessFile raf = new RandomAccessFile("nums.dat", "rw");
            FileChannel fc = raf.getChannel();
            fc.write(bb);
            fc.close(); raf.close();

            ByteBuffer bb1 = ByteBuffer.allocate(TAM / 2 * Integer.BYTES);
            ByteBuffer bb2 = ByteBuffer.allocate(TAM / 2 * Integer.BYTES);
            bb1.clear(); bb2.clear();
            raf = new RandomAccessFile("nums.dat", "r");
            ScatteringByteChannel sbc = raf.getChannel();
            sbc.read(new ByteBuffer[]{bb1, bb2});

            bb1.flip();
            bb2.flip();

            RandomAccessFile raf2 = new RandomAccessFile("nums2.dat", "rw");
            GatheringByteChannel gbc = raf2.getChannel();
            gbc.write(new ByteBuffer[]{bb2, bb1});
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
