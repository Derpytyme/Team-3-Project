package com.app.database;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.*;
import java.util.List;
import java.util.ArrayList;



import static com.mongodb.client.model.Filters.*;

public class Database {
    private String connectionString, databaseName, collectionName;

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;


    public Database(String dbName, String collectionName){
        this.connectionString = "mongodb+srv://benjamincobb:WGfcZDJ18Lm3n5CF@cos225cluster.ztzml.mongodb.net/?retryWrites=true&w=majority&appName=COS225Cluster";
        this.databaseName = dbName;
        this.collectionName = collectionName;


        // Initialize MongoDB connection
        mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase(databaseName);
        collection = database.getCollection(collectionName);
    }

    // Method to search for documents based on user input
    public List<Document> searchByDescription(String userInput) {
        List<Document> results = new ArrayList<>();
        results = collection.find(text(userInput)).into(new ArrayList<>());

        return results;
    }

    // Method to handle search results
    public List<String> getSearchResults(String userInput) {
        List<Document> results = searchByDescription(userInput);
    
        List<String> resultStrings = new ArrayList<>();
    
        return resultStrings;
    }

    // Method to close database connection
    public void close() {
        mongoClient.close();
    }

    }


}