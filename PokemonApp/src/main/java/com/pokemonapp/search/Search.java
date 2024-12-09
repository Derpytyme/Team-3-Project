package com.pokemonapp.search;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;


import org.bson.BsonValue;
import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.pokemonapp.database.Database;
import com.pokemonapp.pokemon.Pokemon;


public class Search {
    private int SearchValue;
    Database database = new Database("pokemon_app_databse", "pokemon_data"); 
    ArrayList<Document> data = new ArrayList<Document>();
    
    
    public Search(int SearchValue){
        this.SearchValue = SearchValue;
        data = database.getAllDocuments();
        ArrayList<Integer> HP = new ArrayList<Integer>();

        for (int i = 0; i<data.size(); i++){
            Pokemon pokemonObject = new Pokemon(data.get(i));
            HP.add(pokemonObject.GetHp());

        }
    }
    public void HPSearch(){
        
    }

    public void AttackSearch(){

    }

    public void DefenseSearch(){

    }

    
}
