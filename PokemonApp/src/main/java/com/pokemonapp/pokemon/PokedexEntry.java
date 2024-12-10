package com.pokemonapp.pokemon;
import org.bson.Document;

public class PokedexEntry {
    private String type, entry;

    public PokedexEntry(String type, String entry) {
        this.type = type;
        this.entry = entry;
    }

    public PokedexEntry(Document document) {
        this.type = document.getString("type");
        this.entry = document.getString("entry");
    }


    public String getType() {
            return type;
    }

    public String getEntry() {
        return entry;
    }

    public Document getDocument() {
        Document document = new Document();
        document.append("type", type);
        document.append("entry", entry);
        return document;
    }
}
