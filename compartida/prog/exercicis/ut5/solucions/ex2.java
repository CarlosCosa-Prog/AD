/*
  2. Programa que s'execute d'igual forma que l'anterior, amb un únic número de línia, i esborre eixa línia del fitxer.
**/
import java.io.*;

public class ex2{

        public static void main (String args[]){
            if (args.length>=2){
                 String linea; int cont=1;
                 File fi = new File(args[0]);
                 File f0 = new File("bmp.txt");
                 
                 try(
                        FileReader fr = new FileReader(fi);
                        BufferedReader br = new BufferedReader(fr);
                        FileWriter fw = new FileWriter(f0);
                    )
                    {
                        linea=br.readLine();
                        int numLinea = Integer.parseInt(args[1]);
                        while(linea != null){
                                if (cont != numLinea)
                                    fw.write(linea+"\n");
                                linea=br.readLine();
                                cont++;
                        }
                        fi.delete();
                        f0.renameTo(fi);
                        //Tanquem els fitxer de les classes que implementen Closeable
                        /*fw.close();
                        br.close();
                        fr.close();*/
                    }
                catch(IOException e){
                        System.err.println(e.getMessage());
                }
            }
            else
                System.out.println("Forma d'ús: java ej2 ruta/Al/Fitxer numLinia");
        }
}
