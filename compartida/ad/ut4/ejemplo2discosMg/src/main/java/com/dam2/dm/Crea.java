package com.dam2.dm;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Crea {
    public static void main(String[] args) {
        MongoClient mc = MongoClients.create("mongodb://localhost/");
        MongoDatabase mdb = mc.getDatabase("midb");
        MongoCollection mcl = mdb.getCollection("discos");

        Document d1 = new Document("_id",1);
        d1.append("title","Giant steps");
        d1.append("band","John Coltrane");
        d1.append("style","jazz");

        mcl.insertOne(d1);
    }
}
