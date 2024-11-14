package src.main.java.com.app.pokemon;

import org.bson.Document;

public class Pokemon {

    private String name;
    private String type1;       // Primary type
    private String type2;       // Secondary type, can be null
    private String description; // Description of the Pokémon

    // Constructor
    public Pokemon(String name, String type1, String type2, String description) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.description = description;
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

    // There are no setters because we don't want to change anything once the MongoDB document is created

    // Converts the object to a MongoDB document
    public Document getDocument() {
        Document document = new Document();
        document.append("Name: ", name);
        document.append("Type1: ", type1);
        document.append("Type2: ", type2);
        document.append("Description: ", description);
        return document;
    }
}