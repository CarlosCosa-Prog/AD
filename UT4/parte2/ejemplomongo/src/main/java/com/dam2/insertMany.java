package com.dam2;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class insertMany {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:20717/midb2"))
        {
            MongoDatabase database = mongoClient.getDatabase("midb2");
            MongoCollection<Document> collection = database.getCollection("discos");

            List<Document> discos = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            String titulo = "";
            int precio = 0;
            int id = 0;

            for (int i = 1; i <= 3; i++) {
                System.out.print("ID:");
                id = sc.nextInt();
                sc.nextLine();
                System.out.println("Titulo:");
                titulo = sc.nextLine();
                System.out.println("Precio:");
                precio = sc.nextInt();
                discos.add(new Document("_id", id)
                            .append("titulo", titulo)
                            .append("precio", precio));
            }
            collection.insertMany(discos);
        }
    }
}
