package com.pokemonapp.menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.result.InsertOneResult;
import com.pokemonapp.database.Database;
import com.pokemonapp.pokemon.Pokemon;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Menu {

//method that will read a csv file and put the collection into the database
public void start() {

    Database pokemonDatabase = new Database("pokemon_app_databse", "pokemon_data");
    pokemonDatabase.createCollection();

    String csvFile = "src/main/resources/pokemon.csv";
    String line;
    String delimiter = "\t";

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        //br.readLine(); //skips header line
        System.out.println(br);

        while ((line = br.readLine()) != null) {
            String[] pokemonData = line.split(delimiter);
            Float nationalNumber = Float.parseFloat(pokemonData[pokemonData.length - 55]);
            String generation = pokemonData[1];
            String englishName = pokemonData[2];
            String japaneseName = pokemonData[3];
            String primaryType = pokemonData[4];
            String secondaryType = pokemonData[5];
            String classification = pokemonData[6];
            Float percentMale = Float.parseFloat(pokemonData[pokemonData.length - 47]);
            Float percentFemale = Float.parseFloat(pokemonData[pokemonData.length - 46]);
            Float height = Float.parseFloat(pokemonData[pokemonData.length - 45]);
            Float weight = Float.parseFloat(pokemonData[pokemonData.length - 44]);
            Float captureRate = Float.parseFloat(pokemonData[pokemonData.length - 43]);
            Float baseEggSteps = Float.parseFloat(pokemonData[pokemonData.length - 42]);
            Float hp = Float.parseFloat(pokemonData[pokemonData.length - 41]);
            Float attack = Float.parseFloat(pokemonData[pokemonData.length - 40]);
            Float defense = Float.parseFloat(pokemonData[pokemonData.length - 39]);
            Float spAttack = Float.parseFloat(pokemonData[pokemonData.length - 38]);
            Float spDefense = Float.parseFloat(pokemonData[pokemonData.length - 37]);
            Float speed = Float.parseFloat(pokemonData[pokemonData.length - 36]);
            String abilities_1 = pokemonData[19];
            String abilities_2 = pokemonData[20];
            String abilities_3 = pokemonData[21];
            String hiddenAbilities = pokemonData[22];
            Float againstNormal = Float.parseFloat(pokemonData[pokemonData.length - 31]);
            Float againstFire = Float.parseFloat(pokemonData[pokemonData.length - 30]);
            Float againstWater = Float.parseFloat(pokemonData[pokemonData.length - 29]);
            Float againstElectric = Float.parseFloat(pokemonData[pokemonData.length - 28]);
            Float againstGrass = Float.parseFloat(pokemonData[pokemonData.length - 27]);
            Float againstIce = Float.parseFloat(pokemonData[pokemonData.length - 26]);
            Float againstFighting = Float.parseFloat(pokemonData[pokemonData.length - 25]);
            Float againstPoison = Float.parseFloat(pokemonData[pokemonData.length - 24]);
            Float againstGround = Float.parseFloat(pokemonData[pokemonData.length - 23]);
            Float againstFlying = Float.parseFloat(pokemonData[pokemonData.length - 22]);
            Float againstPsychic = Float.parseFloat(pokemonData[pokemonData.length - 21]);
            Float againstBug = Float.parseFloat(pokemonData[pokemonData.length - 20]);
            Float againstRock = Float.parseFloat(pokemonData[pokemonData.length - 19]);
            Float againstGhost = Float.parseFloat(pokemonData[pokemonData.length - 18]);
            Float againstDragon = Float.parseFloat(pokemonData[pokemonData.length - 17]);
            Float againstDark = Float.parseFloat(pokemonData[pokemonData.length - 16]);
            Float againstSteel = Float.parseFloat(pokemonData[pokemonData.length - 15]);
            Float againstFairy = Float.parseFloat(pokemonData[pokemonData.length - 14]);
            Float isSublegenedary = Float.parseFloat(pokemonData[pokemonData.length - 13]);
            Float isLegendary = Float.parseFloat(pokemonData[pokemonData.length - 12]);
            Float isMythical = Float.parseFloat(pokemonData[pokemonData.length - 11]); 
            String evolutionChain_1 = pokemonData[44];
            String evolutionChain_2 = pokemonData[45];
            String evolutionChain_3 = pokemonData[46];
            String evolutionChain_4 = pokemonData[47];
            String evolutionChain_5 = pokemonData[48];
            String evolutionChain_6 = pokemonData[49];
            String evolutionChain_7 = pokemonData[50];
            String gigantamax = pokemonData[51];
            String megaEvolution = pokemonData[52];
            String megaEvolutionAlt = pokemonData[53];
            String pokedexDescription = pokemonData[54];

            Pokemon pokemonObject = new Pokemon(englishName, primaryType, secondaryType, pokedexDescription);
            pokemonDatabase.addToDatabase(pokemonObject.getDocument());

        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void end() {
    Database pokemonDatabase = new Database("pokemon_app_database", "pokemon_data");
    pokemonDatabase.deleteCollection();
}

public void addPokemonToDatabase() {

    try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Enter a pokemon name: ");
        String name = scanner.nextLine();
        System.out.println("Enter primary type: ");
        String primaryType = scanner.nextLine();
        System.out.println(" Enter secondary type: ");
        String secondaryType = scanner.nextLine();
        System.out.println("Enter a pokedex-style description: ");
        String description = scanner.nextLine();

        Pokemon pokemonEntry = new Pokemon(name, primaryType, secondaryType, description);
        Database pokemonDatabase = new Database("pokemon_app_database", "pokemon_data");

        pokemonDatabase.addToDatabase(pokemonEntry.getDocument());

    }
}

public static void main(String[] args) {
    Menu menu = new Menu();
    menu.start();
    int choice = 0;

    while (choice !=0){
    System.out.println("***Please select an option***");
    System.out.println("1. Add a pokemon to the database");
    System.out.println("2. HP, Attack and Defense search");
    System.out.println("2. Exit");
    System.out.println("Enter your choice: ");

    try (Scanner scanner = new Scanner(System.in)) {
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                menu.addPokemonToDatabase();
                break;
            
            case 2:
                System.out.println("Entering search...");
                menu.HpAttackDeffenseSearch();
                break;
        

            case 3:
                System.out.println("Exiting...");
                menu.end();
                break;
        
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }
}

}

}