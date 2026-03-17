package org.cosa;

import jakarta.xml.bind.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        // 1. Crear los discos
        Disco d1 = new Disco("disco1",25.99);
        Disco d2 = new Disco("disco2",19.99);
        List<Disco> lista = new ArrayList<>();
        lista.add(d1);
        lista.add(d2);
        Discos discos = new Discos(lista);

        // 2. Crear el fichero xml
        try{
            JAXBContext contexto = JAXBContext.newInstance(discos.getClass());
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(discos, new FileOutputStream("discos.xml"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
