package org.example;

import com.mongodb.client.*;
import org.bson.Document;

// Muestra todos los títulos de los libros

public class ConsultaMuestraNombres {
    public static void main(String[] args) {
        try (MongoClient mongocliente = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongocliente.getDatabase("biblioteca");
            MongoCollection<Document> collection = database.getCollection("libros");

            FindIterable<Document> iterable = collection.find();
            for (Document document : iterable) {
                System.out.println(document.get("titulo"));
            }
        }
    }
}
