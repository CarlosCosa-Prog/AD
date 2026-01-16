import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Random;

//Programa NIO que genera 100 números de lotería aleatorios (entre 0 y 99999), los guarde en un buffer,
// muestre el contenido del buffer y lo escriba a
// fichero .dat


public class Main {
    public static void main(String[] args) {
        ByteBuffer BB = ByteBuffer.allocate(100 );  // HA DE SER 4*100
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < BB.capacity(); i++) {
            int randomise = rand.nextInt(99999);
            BB.put((byte) randomise);

            System.out.println(randomise);
        }

        try(FileChannel fc = new FileOutputStream("loteria.dat").getChannel()) {
        BB.flip();

        while (BB.hasRemaining()) {
            list.add(fc.write(BB));
        }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}