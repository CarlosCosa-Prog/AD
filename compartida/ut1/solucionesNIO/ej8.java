import java.io.IOException;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/* Crea un programa que:

 Genero un fichero notas.dat con las notas de 10 alumnos (cada alumno tiene: ID (int) + Nota (float))

 Llisga el fichero haciendo scattering: un buffer para los IDs y otro para las Notas

 Calculo la media de las notas

 Escriba en un nuevo fichero media.txt el resultado usando gathering: un buffer por el texto y otro por el valor numérico */

public class ej8 {
    public static void main(String[] args) {
        // Dadtos de ejemplo: 10 alumnos (ID + Nota)
        int[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        float[] notas = {7.5f, 8.0f, 6.5f, 9.0f, 5.5f, 8.5f, 7.0f, 6.0f, 9.5f, 8.0f};

        // 1. Escribir datos en binario
        try (FileChannel fc = FileChannel.open(Paths.get("notas.dat"),
                StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

            ByteBuffer buffer = ByteBuffer.allocate((ids.length * 4) + (notas.length * 4));
            buffer.asIntBuffer().put(ids);
            buffer.position(ids.length * 4); // mover a la segunda parte
            buffer.asFloatBuffer().put(notas);
            buffer.flip();
            fc.write(buffer);

        } catch (IOException e) { e.printStackTrace(); }

        // 2. Llegir amb scattering
        try (FileChannel fc = FileChannel.open(Paths.get("notas.dat"), StandardOpenOption.READ)) {

            ByteBuffer idBuffer = ByteBuffer.allocate(ids.length * 4);
            ByteBuffer notasBuffer = ByteBuffer.allocate(notas.length * 4);

            fc.read(new ByteBuffer[]{idBuffer, notasBuffer});

            idBuffer.flip();
            notasBuffer.flip();

            IntBuffer idsLeidos = idBuffer.asIntBuffer();
            FloatBuffer notasLeidas = notasBuffer.asFloatBuffer();

            // 3. Calcular promedio
            float suma = 0;
            while (notasLeidas.hasRemaining()) {
                suma += notasLeidas.get();
            }
            float promedio = suma / notas.length;

            // 4. Escribir resultdo con gathering
            String text = "Promedio de las notas: ";
            ByteBuffer textBuffer = ByteBuffer.wrap(text.getBytes(StandardCharsets.UTF_8));
            ByteBuffer numBuffer = ByteBuffer.allocate(4);
            numBuffer.asFloatBuffer().put(promedio);
            numBuffer.flip();

            try (FileChannel outFc = FileChannel.open(Paths.get("medias.txt"),
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

                outFc.write(new ByteBuffer[]{textBuffer, numBuffer});
            }

        } catch (IOException e) { e.printStackTrace(); }
    }
}