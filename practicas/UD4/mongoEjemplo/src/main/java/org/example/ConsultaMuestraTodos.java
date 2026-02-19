package org.example;

import com.mongodb.client.*;
import org.bson.Document;

// Muestra todos los campos de la colección libros

public class ConsultaMuestraTodos {
    public static void main(String[] args) {
        try (MongoClient mongoCliente = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoCliente.getDatabase("biblioteca");
            MongoCollection<Document> collection = database.getCollection("libros");

            FindIterable<Document> iterable = collection.find();

            for (Document document : iterable) {
                System.out.println(document.toJson());
            }
        }
    }
}
