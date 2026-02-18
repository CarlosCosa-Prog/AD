package org.example;
import org.w3c.dom.ls.LSOutput;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;


public class EJ2 {

    public static <array> void main(String[] args) {

        ByteBuffer bb = ByteBuffer.allocate(Double.BYTES*10);
        double[] nums = new double[10];
        Random random = new Random();

        for(int i=0;i<nums.length;i++){
            double num = random.nextDouble()*10;
            System.out.println("Numero random escritos: " + num);
            bb.putDouble(num);
        }

        bb.flip();
        bb.putDouble(nums[0]);  // NO

        try (FileChannel fcsal = FileChannel.open(Paths.get("EJ2.dat"), StandardOpenOption.CREATE, StandardOpenOption.WRITE)){

            fcsal.write(bb);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        bb.flip();
        // FLIP O CLEAR?
        bb.clear();

        try (FileChannel fcent = FileChannel.open(Paths.get("EJ2.dat"), StandardOpenOption.READ)){

            fcent.read(bb);

            double[] numeross = new double[10];

            for(int i=0;i<numeross.length;i++){
                bb.position(i); // ERROR: posición en bytes, no en double
                System.out.println(bb.getDouble()); // ERROR: getDouble() avanza la posición

            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
