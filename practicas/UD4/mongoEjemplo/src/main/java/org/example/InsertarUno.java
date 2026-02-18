package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

public class InsertarUno {
    public static void main(String[] args) {
        try (MongoClient cliente = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = cliente.getDatabase("biblioteca");
            MongoCollection<Document> collection = db.getCollection("libros");

            Document libro = new Document("_id", new ObjectId());
            libro.append("nombre", "libro")
                    .append("autor","autor")
                    .append("precio",15);
            collection.insertOne(libro);
        }
    }
}
