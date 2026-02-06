package com.dam2.ej1mg;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

public class Update1 {

    public static void main(String[] args) {
        //JsonWriterSettings prettyPrint = JsonWriterSettings.builder().indent(true).build();

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost/biblio")) {
            MongoDatabase mdb = mongoClient.getDatabase("biblio");
            MongoCollection<Document> mco = mdb.getCollection("libros");

            // update one document
            Bson filter = eq("title", "La Biblia de Java");
            //System.out.println(filter.toBsonDocument());
            Bson updateOperation = set("comment", "Aprende también MongoDB!");
            UpdateResult updateResult = mco.updateOne(filter, updateOperation);
            System.out.println("=> Actualizando el documento con {\"titulo\":\"La Biblia de Java\"}. Añadiendo comentario.");
            //System.out.println(mco.find(filter).first().toJson(prettyPrint));
            System.out.println(mco.find(filter).first().toJson());
            System.out.println(updateResult);
        }
    }
}
