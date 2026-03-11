package org.cosa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
// 2. Copia el contenido de un fichero en otro haciendo uso de los métodos estáticos de la clase Files de java.nio.
public class ej2 {
    public static void main(String[] args) throws IOException {
        Path original = Paths.get("textos.txt");
        Path copia = Paths.get("textosCopia.txt");
        Files.copy(original, copia);
    }
}
