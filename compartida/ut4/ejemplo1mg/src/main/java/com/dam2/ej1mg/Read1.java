package com.dam2.ej1mg;

import com.mongodb.client.*;
//import com.mongodb.client.model.Filters;
import com.mongodb.client.model.InsertManyOptions;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.*;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;

public class Read1 {
    public static void main(String[] args) {
        //try (MongoClient mongoClient = MongoClients.create("mongodb+srv://cluster0.zrczf.mongodb.net/sample_training")) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost/biblio")) {

            MongoDatabase mdb = mongoClient.getDatabase("biblio");
            MongoCollection<Document> mco = mdb.getCollection("libros");
            // encontrar un libro
            //Document book1 = mco.find(new Document("cod", 3)).first();
            int cod = 3;
            Document book1 = mco.find(eq("cod", cod)).first();
            System.out.println("Libro de código" + cod + " : " + book1.toJson());

            //FindIterable<Document> iterable = mco.find(new Document("cod", new Document("$gte", 4)));
            // o equivalente haciendo uso de Filters.gte()
            FindIterable<Document> iterable = mco.find(gte("cod", 4));
            MongoCursor<Document> cursor = iterable.iterator();
            System.out.println("Lista de libros con cursor:");
            while (cursor.hasNext()) {
                // EN FORMATO JSON
                System.out.println(cursor.next().toJson());
            }
        }
    }
}

