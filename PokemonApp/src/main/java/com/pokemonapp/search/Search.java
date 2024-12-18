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

    ArrayList<Pokemon> PokemonList = new ArrayList<Pokemon>();
    
    
    public Search(int SearchValue){
        this.SearchValue = SearchValue;
        data = database.getAllDocuments();


        for (int i = 0; i<data.size(); i++){
            Pokemon pokemonObject = new Pokemon(data.get(i));
            PokemonList.add(pokemonObject);
        }



    }
    public void HPSearch(){

        PokemonList.sort( (a, b) -> { return Integer.compare((a.GetHp()), (b.GetHp())); } );
        for (int i = 0; i< PokemonList.size(); i++){
            if (PokemonList.get(i).GetHp() == SearchValue){
                System.out.println(PokemonList.get(i));
                
            }
        }

    }

    public void AttackSearch(){

        
        PokemonList.sort( (a, b) -> { return Integer.compare((a.GetAttack()), (b.GetAttack())); } );
        for (int i = 0; i< PokemonList.size(); i++){
            if (PokemonList.get(i).GetAttack() == SearchValue){
                System.out.println(PokemonList.get(i));
                
            }
        }
        

    }

    public void DefenseSearch(){

        
        PokemonList.sort( (a, b) -> { return Integer.compare((a.Getdefense()), (b.Getdefense())); } );
        for (int i = 0; i< PokemonList.size(); i++){
            if (PokemonList.get(i).Getdefense() == SearchValue){
                System.out.println(PokemonList.get(i));
    
            }
        }

    }

    
}
