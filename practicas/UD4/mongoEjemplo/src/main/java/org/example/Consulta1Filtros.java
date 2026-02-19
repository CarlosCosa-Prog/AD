package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

// Muestra los libros con codigo mayor a 1 y menor que 3

public class Consulta1Filtros {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("biblioteca");
            MongoCollection<Document> collection = database.getCollection("libros");

            FindIterable<Document> iterable = collection.find(and(  gt("cod", 1),
                                                                    lt("cod", 3)
                                                                    ));
            for (Document document : iterable) {
                System.out.println(document.toJson());
            }
        }
    }
}
