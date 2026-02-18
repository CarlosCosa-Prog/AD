package com.dam2.dm;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class CreaMultiple {
    public static void main(String[] args) {
        MongoClient mc = MongoClients.create("mongodb://localhost/");
        MongoDatabase mdb = mc.getDatabase("midb");
        MongoCollection mcl = mdb.getCollection("discos");

        List<Document> l = new ArrayList<Document>();
        l.add(new Document("_id",2).append("title","Street Legal").append("band","Bob Dylan").append("style","rock"));
        l.add(new Document("_id",3).append("title","If I should fall from grace with God").append("band","The Pogues").append("style","rock"));
        l.add(new Document("_id",4).append("title","Slow train coming").append("band","Bob Dylan").append("style","rock"));
        l.add(new Document("_id",5).append("title","Greatest hits").append("band","The Pogues").append("style","rock"));
        l.add(new Document("_id",6).append("title","Saved").append("band","Bob Dylan").append("style","rock"));

        mcl.insertMany(l);
    }
}
