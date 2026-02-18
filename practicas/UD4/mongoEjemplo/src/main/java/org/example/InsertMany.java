package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class InsertMany {
    public static void main(String[] args) {
        try (MongoClient cliente = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = cliente.getDatabase("biblioteca");
            MongoCollection<Document> collection = db.getCollection("libros");

            List<Document> lista = new ArrayList<Document>();

        }
    }
}
