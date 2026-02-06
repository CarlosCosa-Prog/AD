package com.dam2;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class App 
{
    public static void main( String[] args )
    {
        ConnectionString connString = new ConnectionString("mongodb://localhost:27017");
        CodecRegistry pojoCodecRegistry = fromProviders(
                PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .codecRegistry(codecRegistry)
                .build();
        try(
                MongoClient mc = MongoClients.create(clientSettings);
        )
        {
            MongoDatabase mdb = mc.getDatabase("midb");
            MongoCollection<Disco> mco = mdb.getCollection("discos2", Disco.class);
            // insertar un disco
            // public Disco(int id, String titulo, List<String> musicos, String discografica, double precio)
            List<String> musicos = Arrays.asList("James Hedfield","Lars Ullrich");
            Disco d1 = new Disco(1,"Master of Puppets",musicos,"RCA", 20);
            mco.insertOne(d1);

            // insertar múltiples discos
            // No permite array estático de discos (Disco[]), hemos de crear un List<Disco>
            List<Disco> discos = new ArrayList<>();
            List<String> musicos2 = Arrays.asList("Roger Waters","David Gilmour");
            Disco d2 = new Disco(2,"The dark side of the moon",musicos2,"RCA", 30);
            Disco d3 = new Disco(3,"Kill em all",musicos,"RCA", 25);
            discos.add(d2); discos.add(d3);
            mco.insertMany(discos);

            // obtener un disco, el id 2
            Disco dc = mco.find(eq("_id",2)).first();
            System.out.println("El 2º disco es " + dc );
 
            // obtener todos los discos
            //List<Disco> discos2
            FindIterable<Disco> fi = mco.find();
            fi.forEach(d -> System.out.println(d));
        }

    }
}
