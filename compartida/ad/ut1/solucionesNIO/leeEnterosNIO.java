import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class leeEnterosNIO {
    public static void main(String[] args) throws IOException {
        Path f1 = Paths.get("emp2.dat");
        FileChannel fc1 = FileChannel.open(f1, StandardOpenOption.READ);

        ByteBuffer bb = ByteBuffer.allocate(400);
        fc1.read(bb);
        bb.flip();
        IntBuffer ib = bb.asIntBuffer();

        while (ib.hasRemaining()) {
            System.out.printf("%d ", ib.get());
        }
        System.out.println("Fin del fichero");
    }
}
