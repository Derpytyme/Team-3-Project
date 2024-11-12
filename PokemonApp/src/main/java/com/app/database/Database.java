package main.java.com.app.database;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;

public class Database {
    private String connectionString = "mongodb+srv://benjamincobb:WGfcZDJ18Lm3n5CF@cos225cluster.ztzml.mongodb.net/?retryWrites=true&w=majority&appName=COS225Cluster";

    public Database(){
        try (MongoClient mongoclient = MongoClients.create(connectionString)) {


            
        }

    }

    
}