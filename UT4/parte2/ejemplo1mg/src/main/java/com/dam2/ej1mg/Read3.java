package com.dam2.ej1mg;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;

public class Read3 {
    private static final Random rand = new Random();

    public static void main(String[] args) {
        //try (MongoClient mongoClient = MongoClients.create("mongodb+srv://cluster0.zrczf.mongodb.net/sample_training")) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost/biblio")) {

            MongoDatabase mdb = mongoClient.getDatabase("biblio");
            MongoCollection<Document> mco = mdb.getCollection("libros");

            List<Document> docs = mco.find(and(gte("qty", 2), lte("qty", 5)))
                    .projection(fields(excludeId(),
                            include("cod",
                                    "title")))
                    .sort(descending("title"))
                    .skip(1)
                    .limit(2)
                    .into(new Vector<>());  // o con ArrayList

            System.out.println("Listado de libros ordenado, con salto, limitado y proyectado: ");
            for (Document book : docs)
                System.out.println(book.toJson());
            /*Consumer<Document> mostraCada = doc -> System.out.println(doc.toJson());
            docs.forEach(mostraCada);*/
        }
    }
}

