import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propLectura {
    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("props.txt"));
            props.list(System.out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
