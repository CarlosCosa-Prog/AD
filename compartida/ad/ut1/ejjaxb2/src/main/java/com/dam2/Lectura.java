package com.dam2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Lectura
{
    public static void main( String[] args )
    {
        try {
            JAXBContext context = JAXBContext.newInstance(Productos.class );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Productos productos = (Productos) unmarshaller.unmarshal(new File("productos.xml"));
            System.out.println(productos);  // llamada al toString de la clase Productos
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
