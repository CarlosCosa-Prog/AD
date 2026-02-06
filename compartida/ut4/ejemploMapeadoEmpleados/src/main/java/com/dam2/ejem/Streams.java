package com.dam2.ejem;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.function.Consumer;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Streams {
    public static void main(String[] args) {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost");
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();

        try (MongoClient mc = MongoClients.create(clientSettings)) {
            //MongoClient mc = MongoClients.create(connectionString);
            MongoDatabase mdb = mc.getDatabase("midb");
            // Observa que este getCollection (con un 2º parámetro) no retorna Documents, sino Empleados
            MongoCollection<Empleado> empleados = mdb.getCollection("empleados2", Empleado.class);

            ChangeStreamIterable<Empleado> changeStream = empleados.watch();
            changeStream.forEach((Consumer<ChangeStreamDocument<Empleado>>) System.out::println);
            // HAZ UN CAMBIO, POR EJEMPLO EL NOMBRE DE UN EMPLEADO, Y OBSERVA CÓMO REGISTRA EL CAMBIO
            /*for (ChangeStreamDocument<Empleado> empleadoChangeStreamDocument : changeStream)
                System.out.println(empleadoChangeStreamDocument);*/
        }
    }
}
