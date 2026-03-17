package org.cosa.JAXB;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/*Realiza un programa que guarde tres objetos Disco (id,titulo,precio) en un fichero XML.*/
public class ejerecicioJaxb {
    public static void main(String[] args) {
        // 1. Crear los Discos
        Disco d1 = new Disco(1,"disco1",15);
        Disco d2 = new Disco(2,"disco2",20);
        List<Disco> lista = new ArrayList<>();
        lista.add(d1);
        lista.add(d2);
        Discos discos = new Discos(lista);

        // 2. Crear el fichero xml
       try{
           JAXBContext context = JAXBContext.newInstance(discos.getClass());
           Marshaller marshaller = context.createMarshaller();
           marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
           marshaller.marshal(discos,new FileOutputStream("discos.xml"));
       } catch (JAXBException | FileNotFoundException e) {
           throw new RuntimeException(e);
       }
    }
}
