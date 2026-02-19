package org.example;

import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.Document;

// Comprueba si se conecta correctamente con la base de datos de mongodb

public class Conectar {
    public static void main(String[] args) {
        MongoClient cliente = MongoClients.create("mongodb://localhost:27017");
        System.out.println("Conexión establecida correctamente");
        MongoDatabase db = cliente.getDatabase("biblioteca");
        MongoCollection<Document> usuarios = db.getCollection("libros");
    }
}
