package com.dam2;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

public class inertOne {
    public static void main(String[] args) {
        // Primero crear el mongoClient pasandole mongodb://localhost/nombreDeLaBaseDeDatos
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost/midb2"))
        {
            // Crear el MongoDatabase y MongoCollection
            MongoDatabase database = mongoClient.getDatabase("midb2");
            MongoCollection<Document> collection = database.getCollection("discos");

            // Crear el document con los campos
            Document disco = new Document("_id", 1);
            disco.append("titulo", "disco1")
                .append("precio", 25);

            // Hacer el insertOne a la colección
            collection.insertOne(disco);
        }
    }
}
