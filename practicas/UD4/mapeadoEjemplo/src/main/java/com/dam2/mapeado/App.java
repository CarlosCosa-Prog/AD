package com.dam2.mapeado;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.sql.Connection;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class App {
    public static void main(String[] args) {
        ConnectionString cs = new ConnectionString("mongodb://localhost:27017");
        CodecRegistry pcr = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry cr = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),pcr);
        MongoClientSettings mcs = MongoClientSettings.builder()
                .applyConnectionString(cs)
                .codecRegistry(cr)
                .build();
        try(MongoClient mongoClient = MongoClients.create(mcs)){
            MongoDatabase databse = mongoClient.getDatabase("pruebas");
            MongoCollection<Videojuego> collection = databse.getCollection("videojuegos",Videojuego.class);

            Videojuego v1 = new Videojuego(1,"prueba",15);
            collection.insertOne(v1);

        }

    }
}
