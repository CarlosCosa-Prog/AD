package com.dam2;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;


public class InsertarUnDisco
{
   public static  void main( String[] args )
   {

       try (MongoClient client = MongoClients.create("mongodb://localhost:27017/midb")) {
           MongoDatabase database = client.getDatabase("midb");
           MongoCollection<Document> collection = database.getCollection("undisco");

           Document document = new Document();
           document.append("id", "1")
           .append("nombre", "Dam")
           .append("descripcion", "Dam");
       }
   }
}
