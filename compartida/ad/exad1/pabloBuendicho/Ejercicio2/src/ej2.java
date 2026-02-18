import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.util.Random;

public class ej2 {
    public static void main(String[] args) {
        ByteBuffer bf = ByteBuffer.allocate(100*Integer.BYTES);

        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            int num = r.nextInt(100000);
            bf.putInt(num);
        }

        bf.flip();
        for(int i=1;i<=100;i++){
            System.out.println("La posición "+i+" es: "+bf.getInt());
        }

        try(RandomAccessFile raf = new RandomAccessFile("loteria.dat", "rw");
            FileChannel fc = raf.getChannel();) {
            bf.flip();
            fc.write(bf);
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
