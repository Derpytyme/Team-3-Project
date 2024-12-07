package com.pokemonapp.nlp;

import java.util.HashMap;
import java.util.HashSet;

import org.bson.BsonValue;

import com.pokemonapp.pokemon.Pokemon;

public class PokemonClassifier {
    private Processor processor;
    private HashSet<String> vocabulary = new HashSet<>();

    public PokemonClassifier(Processor processor) {
        this.processor = processor;
    }
    
    public void addSample(BsonValue id, String description) {
        //needs implimentation
    }



    public String classify(String description) {
        //needs implimentation
        String clasification = " ";
        return clasification;
    }
}
