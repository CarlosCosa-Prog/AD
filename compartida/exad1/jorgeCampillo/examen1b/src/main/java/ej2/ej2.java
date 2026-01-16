package ej2;

import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.file.AccessMode;
import java.nio.file.StandardOpenOption;

public class ej2 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        ByteBuffer buffer2 = ByteBuffer.allocate(10);
        do{
            int num = buffer.getInt();
            if(num > 0){
                //FileChannel.open(buffer.getInt(), StandardOpenOption.CREATE("ej1.txt"), AccessMode.WRITE);
                //FileChannel.open(buffer2.getInt(), StandardOpenOption.READ("ej1.txt"), AccessMode.READ);
            }
            buffer.clear();
        }while(true);
    }
}
