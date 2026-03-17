package org.cosa;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Disco d1 = new Disco("Disco1",24.77);
        Disco d2 = new Disco("Disco2",15);
        List<Disco> lista = new ArrayList<>();
        lista.add(d1);
        lista.add(d2);
        Discos discos = new Discos(lista);

        try{
            JAXBContext context = JAXBContext.newInstance(discos.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            marshaller.marshal(discos,new FileOutputStream("discos.xml"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
