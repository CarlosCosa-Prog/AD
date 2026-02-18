package org.example;

import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.Document;

public class Conectar {
    public static void main(String[] args) {
        MongoClient cliente = MongoClients.create("mongodb://localhost:27017");
        System.out.println("Conectado com sucesso!");
        MongoDatabase db = cliente.getDatabase("biblioteca");
        MongoCollection<Document> usuarios = db.getCollection("libros");
    }
}
