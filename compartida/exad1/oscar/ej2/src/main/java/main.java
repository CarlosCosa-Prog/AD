import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class main{
    public static void main(String[] args) {
        // creamos el byte buffer que vamos a usar para leer y esctibir
        // PEDÍA REALES, NO ENTEROS
        ByteBuffer buffer = ByteBuffer.allocate(10 * Integer.BYTES);

        try(FileChannel documento = FileChannel.open(Paths.get("numerosEj1.txt"), StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        ){ //final channel para acceder al documento y crearlo
            //escritura
            for(int i = 0; i < 10; i++){
                buffer.putInt((int)(Math.random()*10)); //poemos los numero al azar
            }
            buffer.flip(); // nos preparamos para escribir estableciendo limite y principoi
            documento.write(buffer);

            //lectura
            // AQUÍ DEBÍAS HACER clear()
            buffer.flip();
            documento.read(buffer);

            System.out.println("Numeros al azar");
            while(buffer.hasRemaining()){
                System.out.println(buffer.getInt());
            }



        }catch (IOException e){
            e.printStackTrace();
        }
    }




}
