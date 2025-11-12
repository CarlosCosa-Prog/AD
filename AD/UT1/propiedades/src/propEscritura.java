import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class propEscritura {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("nombre", "Carlos");
        props.setProperty("direccion", "Petrer");
        props.setProperty("telefono", "123456789");
        props.setProperty("edad", "21");
        try {
            props.store(new FileOutputStream("props.txt"), "Ejemplo de propiedades");
        }catch (FileNotFoundException e)
            {
            System.out.println("No se encontro el archivo");
            }
        catch (IOException e)
            {
            System.out.println("Error al escribir el archivo");
            }

    }
}
