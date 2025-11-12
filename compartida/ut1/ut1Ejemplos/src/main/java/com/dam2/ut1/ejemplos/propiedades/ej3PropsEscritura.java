package com.dam2.ut1.ejemplos.propiedades;

import java.util.*;
import java.io.*;

public class ej3PropsEscritura
{
    public static void main(String args[])
    {
        Properties configuracion = new Properties();
        configuracion.setProperty("user", "rca");
        configuracion.setProperty("password", "pass1");
        configuracion.setProperty("server", "miservidorDAM2");
        configuracion.setProperty("port", "9999");
        try {
            configuracion.store(new FileOutputStream("configuracion.txt"),"Fichero de configuracion para mi aplicación en DAM2");
        } catch (FileNotFoundException fnfe ) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
