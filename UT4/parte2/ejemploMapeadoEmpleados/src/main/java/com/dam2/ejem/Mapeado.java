package com.dam2.ejem;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Mapeado {
    public static void main(String[] args) {
        //ConnectionString connectionString = new ConnectionString(System.getProperty("mongodb.uri"));
        ConnectionString connectionString = new ConnectionString("mongodb://localhost");
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();

        try ( MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("midb");
            MongoCollection<Empleado> empleados = db.getCollection("empleados2", Empleado.class);
            // mostramos todos
            MongoCursor<Empleado> mc = empleados.find().iterator();
            while(mc.hasNext())
                System.out.println(mc.next());

            //MongoCollection<Direccion> direcciones = db.getCollection("direcciones", Direccion.class);
            Direccion dir = new Direccion("calle","Méndez Núñez",99);
            //List<Direccion> dirs = new ArrayList<>();
            //dirs.add(dir);
            //Empleado emp = new Empleado("Ferran Rodoreda",dirs);
            //Empleado emp = new Empleado("Ferran Rodoreda");
            Empleado emp = new Empleado();
            emp.setNombre("Ferran Rodoreda");
            emp.addDir(dir);
            emp.setId(new ObjectId());
            //emp.setDirs(dirs);
            //direcciones.insertOne(dir);
            empleados.insertOne(emp);

            // volvemos a mostrar todos
            System.out.println("volvemos a mostrar todos");
            mc = empleados.find().iterator();
            while(mc.hasNext())
                System.out.println(mc.next());

            // actualizamos
            Bson filtro = Filters.eq("nombre", "Ferran Rodoreda");
            Bson update = Updates.set("nombre", "Felix Lledó");
            empleados.updateOne(filtro, update);

            // volvemos a mostrar todos
            System.out.println("volvemos a mostrar todos");
            mc = empleados.find().iterator();
            while(mc.hasNext())
                System.out.println(mc.next());

            // borramos uno
            empleados.deleteOne(filtro);

            // volvemos a mostrar todos
            System.out.println("volvemos a mostrar todos");
            mc = empleados.find().iterator();
            while(mc.hasNext())
                System.out.println(mc.next());

        }
    }
}
