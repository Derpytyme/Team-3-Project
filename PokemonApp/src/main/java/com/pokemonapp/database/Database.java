package com.pokemonapp.database;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


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

    public void addToDatabase(Document document) {

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            MongoDatabase pokemonDatabase = mongoClient.getDatabase(this.databaseName);
            MongoCollection<Document> pokemonCollection = pokemonDatabase.getCollection(this.collectionName);

            pokemonCollection.insertOne(document);

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

            MongoDatabase movieDatabase = mongoClient.getDatabase(this.databaseName);
            movieDatabase.getCollection(this.collectionName).drop();

        }

    }

    }


