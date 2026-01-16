/*
* 0. Crea un objeto FileSystem a partir de la clase FileSystems. A partir del primero, obtén un objeto Path asociado al
* fichero a crear con el nombre "textos.txt".
* Utilizando algún método estático de la clase Files escribe "Primera línea\n" y "Segunda línea\n" en dicho fichero.
* Asegúrate de que se crea al escribir, truncando el contenido del fichero si ya existiera de ejecuciones anteriores.
* Acaba mostrando el contenido del fichero haciendo uso también de algún otro método estático de la clase Files.
* */
import java.nio.*;
public  class ex0{
    public static void main(String args[]){
        FileSystem fs = new FileSystem.getDefault();
        Path p = fs.getPath("textos.txt");
        Files.writeString(p,"Primera linea\nSegunda linea\n",
                StandardCharsets.UTF_8, StandardOpenOption.APPEND, StandardOpenOption.TRUNCATE_EXISTING);
        File.readString(p);

    }
}