package com.dam2.ej1mg;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.set;

public class Delete1 {

    public static void main(String[] args) {
        JsonWriterSettings prettyPrint = JsonWriterSettings.builder().indent(true).build();

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost/biblio")) {
            MongoDatabase mdb = mongoClient.getDatabase("biblio");
            MongoCollection<Document> mco = mdb.getCollection("libros");

            // update one document
            Bson filter = and(eq("title", "La Biblia de Java"),eq("cod", 1));
            //System.out.println(filter.toBsonDocument());
            DeleteResult deleteResult = mco.deleteOne(filter);
            System.out.println("Eliminando el documento con título La Biblia de Java");

            System.out.println("Elementos borrados: " + deleteResult.getDeletedCount());
        }
    }
}
