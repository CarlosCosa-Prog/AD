package org.example;

import com.mongodb.client.*;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

// Actualizar el titulo con el id 3

public class Actualizar {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("biblioteca");
            MongoCollection<Document> collection = database.getCollection("libros");

            // Bson que filtra por cod = 3
            Bson filter = eq("cod", 3);
            // Bson que actualiza el campo título
            Bson update = set("titulo", "It");
            // Realiza la actualización de un documento y guarda el resultado de la operación
            UpdateResult result = collection.updateOne(filter, update);
            System.out.println(result);
        }
    }
}
