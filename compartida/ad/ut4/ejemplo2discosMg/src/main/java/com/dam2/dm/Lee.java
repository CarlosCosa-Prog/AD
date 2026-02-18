package com.dam2.dm;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;

// IMPORTANTE!: OBSERVA ESTE IMPORT STATIC (CLASE FILTERS)
import static com.mongodb.client.model.Filters.eq;

public class Lee {
    public static void main(String[] args) {
        MongoClient mc = MongoClients.create("mongodb://localhost");
        MongoDatabase mdb = mc.getDatabase("midb");
        MongoCollection mcl = mdb.getCollection("discos");
        // Mostramos uno en concreto
        Bson bs = eq("_id",2);
        Document d = (Document) mcl.find(bs).first();
        System.out.println(d);
        // Mostramos todos
        MongoCursor mcu = mcl.find().iterator();
        while (mcu.hasNext())
            System.out.println(mcu.next());
    }
}
