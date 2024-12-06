package com.pokemonapp.menu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import org.bson.BsonValue;

import com.mongodb.client.result.InsertOneResult;
import com.pokemonapp.database.Database;
import com.pokemonapp.pokemon.Pokemon;
import com.pokemonapp.search.Search;


public class Menu {

//method that will read a csv file and put the collection into the database
public void start() {

    Database pokemonDatabase = new Database("pokemon_app_databse", "pokemon_data");
    pokemonDatabase.createCollection();

    String csvFile = "src/main/resources/pokemondatanew.csv";
    String line;
    String delimiter = ",";

    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        br.readLine(); //skips header line

        while ((line = br.readLine()) != null) {
            String[] pokemonData = line.split(delimiter);
            String englishName = pokemonData[0];
            String primaryType = pokemonData[1];
            String secondaryType = pokemonData[2];
            String Shp = pokemonData[3];
            String Sattack = pokemonData[4];
            String Sdefense = pokemonData[5];
            String pokedexDescription = pokemonData[6];

            //casting the strings read from the CSV to integers
            int hp = Integer.parseInt(Shp.trim());
            int attack = Integer.parseInt(Sattack.trim());
            int defense = Integer.parseInt(Sdefense.trim());

            Pokemon pokemonObject = new Pokemon(englishName, primaryType, secondaryType, pokedexDescription, hp, attack, defense);
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
        System.out.println("Enter HP: ");
        int HP = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Attack: ");
        int Attack = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Defense");
        int Defense = Integer.parseInt(scanner.nextLine());

        Pokemon pokemonEntry = new Pokemon(name, primaryType, secondaryType, description, HP, Attack, Defense);
        Database pokemonDatabase = new Database("pokemon_app_database", "pokemon_data");

        pokemonDatabase.addToDatabase(pokemonEntry.getDocument());

    }
}

public void HpAttackDeffenseSearch(){
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the value you would like to search for: ");
    int SearchValue = scan.nextInt();

    int choice = 0;
    while (choice !=0){
        System.out.println("***Please select an option***");
        System.out.println("1. HP search");
        System.out.println("2. Attack search");
        System.out.println("3. Defense search");
        System.out.println("Enter your choice: ");
    
        try (Scanner scanner = new Scanner(System.in)) {
            choice = scanner.nextInt();
            
            scanner.nextLine();
            
            Search searcher = new Search(SearchValue);
            switch (choice) {
                case 1:
                    searcher.HPSearch();
                    break;
                
                case 2:
                    searcher.AttackSearch();
                    break;
            
    
                case 3:
                    searcher.DefenseSearch();
                    break;
            
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        
        }
    }
    
}
public static void main(String[] args) {
    System.out.println("Initializing Pokemon app...");

    Menu menu = new Menu();
    menu.start();
    System.out.println("***Please select an option***");

    int choice = 0;

    while (choice !=0){
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