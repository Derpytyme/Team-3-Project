package com.pokemonapp.database;

import java.util.ArrayList;

import org.bson.BsonValue;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;


public class Database {
    private String connectionString, databaseName, collectionName;

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;


    public Database(String dbName, String collectionName){
        this.connectionString = "mongodb+srv://benjamincobb:WGfcZDJ18Lm3n5CF@cos225cluster.ztzml.mongodb.net/?retryWrites=true&w=majority&appName=COS225Cluster";
        this.databaseName = dbName;
        this.collectionName = collectionName;
    }

    public Database(String connectionString, String dbName, String collectionName) {
        this.connectionString = connectionString;
        this.databaseName = dbName;
        this.collectionName = collectionName;

    }

    public InsertOneResult addToDatabase(Document document) {

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            MongoDatabase pokemonDatabase = mongoClient.getDatabase(this.databaseName);
            MongoCollection<Document> pokemonCollection = pokemonDatabase.getCollection(this.collectionName);

            return pokemonCollection.insertOne(document);

        }

    }

    public void createCollection() {

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            MongoDatabase pokemonDatabase = mongoClient.getDatabase(this.databaseName);
            pokemonDatabase.createCollection(this.collectionName);

        }

    }

    public void deleteCollection() {

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            MongoDatabase pokemonDatabase = mongoClient.getDatabase(this.databaseName);
            pokemonDatabase.getCollection(this.collectionName).drop();

        }

    }

    public void deleteAllDocuments() {

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            MongoDatabase pokemonDatabase = mongoClient.getDatabase(this.databaseName);
            MongoCollection<Document> pokemonCollection = pokemonDatabase.getCollection(this.collectionName);

            pokemonCollection.deleteMany(new Document());

        }

    }

    public ArrayList<Document> getAllDocuments() {

        ArrayList<Document> documents = new ArrayList<Document>();

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            MongoDatabase genericDatabase = mongoClient.getDatabase(this.databaseName);
            MongoCollection<Document> genericCollection = genericDatabase.getCollection(this.collectionName);

            for (Document doc : genericCollection.find()) {
                documents.add(doc);
            }

        }
        
        return documents;

    }

    public Document getDocumentByID(BsonValue id) {

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            MongoDatabase genericDatabase = mongoClient.getDatabase(this.databaseName);
            MongoCollection<Document> genericCollection = genericDatabase.getCollection(this.collectionName);

            return genericCollection.find(new Document("_id", id)).first();

        }

    }

    }


