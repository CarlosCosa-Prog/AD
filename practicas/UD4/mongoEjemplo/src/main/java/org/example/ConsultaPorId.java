package org.example;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.Scanner;

import static com.mongodb.client.model.Filters.*;

// Muestra el titulo de un libro según su codigo

public class ConsultaPorId {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("biblioteca");
            MongoCollection<Document> collection = database.getCollection("libros");

            System.out.println("Ingrese el codigo del libro para saber su nombre:");
            int cod = Integer.parseInt(sc.nextLine());

            // Busca un libro por su código
            // first devuelve el primer document que cumple el filtro
            Document libro = collection.find(eq("cod",cod)).first();
            System.out.println("El nombre del libro " + cod + " es: " + libro.get("titulo"));
        }
    }
}