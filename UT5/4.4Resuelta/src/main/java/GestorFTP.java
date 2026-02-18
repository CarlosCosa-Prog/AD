import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.*;


public class GestorFTP {
    private FTPClient clienteFTP;
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 21;
    private static final String USUARIO = "admin";
    private static final String PASSWORD = "admin";

    public GestorFTP() {
        clienteFTP = new FTPClient();
    }
    public void conectar() throws SocketException,IOException {
        clienteFTP.connect(SERVIDOR, PUERTO);
        int resupesta = clienteFTP.getReplyCode();
        if (!FTPReply.isPositiveCompletion(respuesta)){
            clienteFTP.disconnect();
            throw new IOException("Error al conectar con el servidor FTP");
        }
        boolean credencialesOK = clienteFTP.login(USUARIO, PASSWORD);
        if (!credencialesOK){
            throw new IOException("Error al conectar con el servidor FTP. Credenciales incorrectas.");
        }
        clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);
    }
}
