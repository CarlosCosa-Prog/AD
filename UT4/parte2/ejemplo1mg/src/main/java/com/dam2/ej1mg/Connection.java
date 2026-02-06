package com.dam2.ej1mg;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Connection
{
    public static void main(String[] args)
    {

        //try (MongoClient mongoClient = MongoClients.create("mongodb+srv://usuario:password@cluster0.zrczf.mongodb.net")) {
        // HACEMOS USO DEL TRY-WITH-RESOURCES POR EL AUTOCLOSE
        // OBSERVA CÓMO CREAMOS EL MONGOCLIENT CON EL MÉTODO ESTÁTICO CREATE DE MONGOCLIENTS
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost"))
        {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            // MOSTRAMOS CADA BASE DE DATOS CON FORMATO JSON
            databases.forEach(db -> System.out.println(db.toJson()));
            /* for (Document document : databases) {
                System.out.println(document.toJson());*/
        }
    }
}