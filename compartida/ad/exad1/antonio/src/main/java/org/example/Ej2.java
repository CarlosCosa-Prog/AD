package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.StandardOpenOption;

public class Ej2 {
    public static void main(String[] args) {
        int TAM=100;
        int[] nums = new int[100];
        FileSystem fs = FileSystems.getDefault();

        // NO NECESITAS ESTE ARRAY, UTILIZA DIRECTAMENTE EL BUFFER
        for (int i = 0; i < TAM; i++)
            nums[i] = (int) (Math.random() * 1000000);

        try {
            FileChannel fc = FileChannel.open(fs.getPath("loteria.dat"),StandardOpenOption.CREATE, StandardOpenOption.WRITE);

            ByteBuffer bb = ByteBuffer.allocate(TAM * Integer.BYTES);
            IntBuffer ib = bb.asIntBuffer();
            ib.put(nums);
            System.out.println(ib.position());
            ib.flip();
            bb.position(TAM * Integer.BYTES);
            bb.flip();
            while(ib.position()!=ib.limit())
                System.out.println(ib.get());
            fc.write(bb);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
