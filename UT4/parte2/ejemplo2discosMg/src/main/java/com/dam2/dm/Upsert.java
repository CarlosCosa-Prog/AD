package com.dam2.dm;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

public class Upsert {
    public static void main(String[] args) {
        MongoClient mc = MongoClients.create("mongodb://localhost/");
        MongoDatabase mdb = mc.getDatabase("midb");
        MongoCollection mcl = mdb.getCollection("discos");

        UpdateOptions options = new UpdateOptions();
        options.upsert(true);
        Document d1 = new Document(/*"_id", 7*/).append("title","Elevation").append("band","Pharoah Sanders")/*.append("style","jazz")*/;
        // collection.updateOne(filter, update, options)
        Bson filter = Filters.eq("_id", 8);
        Bson update = Updates.combine(Updates.set("style","jazz"),Updates.setOnInsert(d1));
        //UpdateOptions options = new UpdateOptions().upsert(false);
        //UpdateOptions options = new UpdateOptions().upsert(true);
        mcl.updateOne(filter,update,options);

            // Para preparar tubería con agregación (aggregation-pipeline)
        filter = Filters.gt("_id",0);
        update = Updates.set("precio",15);
        mcl.updateMany(filter,update);
    }
}
