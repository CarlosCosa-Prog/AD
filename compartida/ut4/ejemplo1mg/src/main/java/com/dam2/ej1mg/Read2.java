package com.dam2.ej1mg;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;

public class Read2 {

    public static void main(String[] args) {
        //try (MongoClient mongoClient = MongoClients.create("mongodb+srv://cluster0.zrczf.mongodb.net/sample_training")) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost/biblio")) {

            MongoDatabase mdb = mongoClient.getDatabase("biblio");
            MongoCollection<Document> mco = mdb.getCollection("libros");

            List<Document> bookList = mco.find(gte("cod", 4)).into(new ArrayList<>());
            for (Document book : bookList)
                System.out.println(book.toJson());
            /*Consumer<Document> printConsumer = document -> System.out.println(document.toJson());
            mco.find(gte("cod", 4)).forEach(printConsumer);*/
        }
    }
}

