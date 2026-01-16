import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

public class ej1 {
    public static void main(String[] args) {

        //creamos el fichero y lo guardamos con file
        try (FileInputStream fis = new FileInputStream("examen.conf")) {
            try (FileOutputStream fos = new FileOutputStream("examen.conf")) {

                Properties prop = new Properties();
                //guardar las propiedades de nombre
                prop.setProperty("Nombre", "Alejandro");
                prop.setProperty("Apellidos", "Martinez");
                prop.setProperty("Materia", "2DAM");

                prop.store();   // NO EXISTE STORE() SIN PARÁMETROS

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}// FALTABA ESTA LLAVE FINAL