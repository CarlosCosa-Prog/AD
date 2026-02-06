package com.dam2.ej1mg;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.InsertManyOptions;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.*;

public class CreateMany {
    private static final Random rand = new Random();
        public static void main(String[] args) {
            //try (MongoClient mongoClient = MongoClients.create("mongodb+srv://cluster0.zrczf.mongodb.net/sample_training")) {
            try (MongoClient mongoClient = MongoClients.create("mongodb://localhost/biblio")) {

                MongoDatabase mdb = mongoClient.getDatabase("biblio");
                MongoCollection<Document> mco = mdb.getCollection("libros");

                List<Document> libros = new ArrayList<>();
                Scanner ent = new Scanner(System.in);
                String tit="";
                for (int qty = 2; qty <= 5 ; qty++) {
                    System.out.println("Título:");
                    tit = ent.nextLine();
                    libros.add(generaLibro(qty, tit,30,30,"cm"));
                }
        // INSERTMANY CON PRIMER PARÁMETRO EL ARRAYLIST
                mco.insertMany(libros, new InsertManyOptions().ordered(false));
            }
        }
        // TITULO CANTIDAD, ALTO, ANCHO, UNIDAD DE MEDIDA
        public static Document generaLibro(int q,String t, int h, int w, String un)
        {
            // SEPARAMOS EL TITULO EN PALABRAS
            String[] result = t.split("\\s");

            Document book = new Document("_id", new ObjectId());
            book.append("cod",q)    // hacemos que código y cantidad coincidan en valor
                .append("title", t)
                .append("qty",q)
                    .append("tags", Arrays.asList(result))
                    .append("size", new Document("h",h).append("w",w).append("uom",un));

return book;
        }
    }

