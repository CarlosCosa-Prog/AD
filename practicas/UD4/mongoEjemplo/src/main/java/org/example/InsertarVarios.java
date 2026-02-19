package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Inserta 3 libros en la colección "libros"

public class InsertarVarios {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try (MongoClient cliente = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase db = cliente.getDatabase("biblioteca");
            MongoCollection<Document> collection = db.getCollection("libros");

            List<Document> lista = new ArrayList<Document>();
            String titulo = "";

            for (int i = 1; i <= 3; i++) {
                System.out.println("Introduce el titulo del libro " + i);
                titulo = sc.nextLine();
                lista.add(new Document("cod", i).append("titulo", titulo));
            }
            collection.insertMany(lista);
        }
    }
}
