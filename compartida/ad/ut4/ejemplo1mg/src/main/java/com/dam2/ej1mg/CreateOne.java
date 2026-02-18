package com.dam2.ej1mg;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.Random;

public class CreateOne {
        public static void main(String[] args) {
            //try (MongoClient mongoClient = MongoClients.create("mongodb+srv://cluster0.zrczf.mongodb.net/sample_training")) {
            try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017/biblio")) {

                MongoDatabase mdb = mongoClient.getDatabase("biblio");
                MongoCollection<Document> mco = mdb.getCollection("libros");
                //Random rand = new Random();
                Document book = new Document("_id", new ObjectId());
                book.append("cod",1)
                        .append("title", "La Biblia de Java")
                        .append("qty", 50)
                        .append("tags", Arrays.asList("programacion"))
                        .append("size", new Document("h",40 ).append("w",30).append("udm","cms"));

                mco.insertOne(book);
            }
        }
    }

