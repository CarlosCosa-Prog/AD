package org.example;

import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.*;

// Borrar el libro con el id 3

public class Borrar {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("biblioteca");
            MongoCollection<Document> collection = database.getCollection("libros");

            int cod = 3;
            Bson filter = eq("cod", cod);
            DeleteResult deleteResult = collection.deleteOne(filter);
            System.out.println("Libro de codigo " + cod + " borrado correctamente");
        }
    }
}
