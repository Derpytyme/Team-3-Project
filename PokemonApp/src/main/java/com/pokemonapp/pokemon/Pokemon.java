package com.pokemonapp.pokemon;

import org.bson.Document;

public class Pokemon {

    private String name;
    private String type1;       // Primary type
    private String type2;       // Secondary type, can be null
    private String description; // Description of the Pokémon
    private int hp;
    private int attack;
    private int defense;

    // Constructor
    public Pokemon(String name, String type1, String type2, String description, int hp, int attack, int defense) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2; 
        this.description = description;
        this.hp = hp;
        this.attack = attack;
        this.defense=defense;
    }

    // Constructor
    public Pokemon(Document document) {
        this.name = document.getString("name");
        this.type1 = document.getString("type1");
        this.type2 = document.getString("type2");
        this.description = document.getString("description");
        try{
            this.hp = document.getInteger("hp");
            this.attack = document.getInteger("attack");
            this.defense = document.getInteger("defense");
        } catch (NullPointerException e) {
            //System.out.println("Null Value"); // disable comment to see errors
        }


    }

    // Getters
    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getDescription() {
        return description;
    }
    
    public int GetHp() {
        return hp;
    }

    public int GetAttack() {
        return attack;
    }

    public int Getdefense() {
        return defense;
    }

    // There are no setters because we don't want to change anything once the MongoDB document is created

    // Converts the object to a MongoDB document
    public Document getDocument() {
        Document document = new Document();
        document.append("name", name);
        document.append("type1", type1);
        document.append("type2", type2);
        document.append("description", description);
        document.append("hp", hp);
        document.append("attack", attack);
        document.append("defense", defense);
        return document;
        
    }

    public String toString() {
        return "Name: " + getName() + ", \tHP: " + GetHp() + ", \tAttack: " + GetAttack() + ", \tDefense: " + Getdefense();
    }
}
