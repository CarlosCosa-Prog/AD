/* 12. Crea una classe Diccionari amb 2 atributs per a contindre la mateixa paraula en 2 idiomes.
 Realitza un programa que serialitze 10 objectes Diccionari a fitxer.
 El programa acabarà mostrant els objectes llegits des de fitxer. */

import java.io.*;
import java.util.Vector;

class Diccionari implements Serializable{
    private String valencia;
    private String castella;

    public Diccionari() {
    }

    public Diccionari(String valencia, String castella) {
        this.valencia = valencia;
        this.castella = castella;
    }

    public String getValencia() {
        return valencia;
    }

    public void setValencia(String valencia) {
        this.valencia = valencia;
    }

    public String getCastella() {
        return castella;
    }

    public void setCastella(String castella) {
        this.castella = castella;
    }

    @Override
    public String toString() {
        return "Diccionari{" +
                "valencia='" + valencia + '\'' +
                ", castella='" + castella + '\'' +
                '}';
    }
}

public class ex12 {
    public static void main(String[] args) {

        Diccionari d1 = new Diccionari("gat","gato");
        Diccionari d2 = new Diccionari("canari","canario");
        Diccionari d3 = new Diccionari("peix","pez");

        Vector<Diccionari> ds = new Vector<>();
        ds.add(d1); ds.add(d2); ds.add(d3);

        // serialitzar
        try(FileOutputStream fos= new FileOutputStream("diccionari.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);)
        {
            for (Diccionari d: ds)
                oos.writeObject(d);
        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
        ds.removeAllElements();
        // deserialitzar
        try(FileInputStream fis= new FileInputStream("diccionari.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);)
        {
            while (true)
            {
                d1 = (Diccionari) ois.readObject();
                ds.add(d1);
            }
        }
        catch(EOFException e)
        { }
        catch(IOException | ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
        System.out.println("El contingut del fitxer era:");
        for (Diccionari d: ds)
            System.out.println(d);
    }
}