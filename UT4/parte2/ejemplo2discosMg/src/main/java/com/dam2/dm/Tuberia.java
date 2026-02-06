package com.dam2.dm;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;

public class Tuberia {
    /*  Vamos a seleccionar los 2 músicos de rock con lote de discos más caro.

    No necesito trabajar con toda la colección, filtraré sólo los DISCOS DE ROCK.
    Hecho esto, puedo agrupar los DISCOS DE UN MISMO MUSICO para CALCULAR EL PRECIO DE TODOS ELLOS.
    Entonces ordenaré MUSICOS por precio descendiente DE TODO EL LOTE DE SUS DISCOS.
    Finalmente extraeré los 2 primeros MUSICOs de la lista  */

    public static void main(String[] args) {
        MongoClient mc = MongoClients.create("mongodb://localhost/");
        MongoDatabase mdb = mc.getDatabase("midb");
        MongoCollection mcl = mdb.getCollection("discos");

        mostExpensiveMusician(mcl);
  }

    private static void mostExpensiveMusician(MongoCollection<Document> mc) {
        Bson match = match(eq("style", "rock"));
        //Bson match = Filters.eq("style", "rock");
        Bson group = group("$band", sum("totalPrecio", "$precio"));
        //Bson project = project(fields(excludeId(), include("totalPrecio"), computed("band", "$_id")));
        Bson sort = sort(descending("totalPrecio"));
        Bson limit = limit(2);

        List<Document> results = mc.aggregate(Arrays.asList(match, group/*, project*/, sort, limit))
                .into(new ArrayList<>());

        System.out.println("==> Los 2 músicos más caros en rock son:");
        for (Document d: results)
                 System.out.println(d.toJson());
    }
}
