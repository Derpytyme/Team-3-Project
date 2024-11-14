package main.java.com.app.pokemon;

import org.bson.Document;
import java.util.ArrayList;

public class Pokemon {
    String name;
    ArrayList<String> types;
    String caption;

    public String getName() {
        return name;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public String getCaption() {
        return caption;
    }

    public Document getDocument() {
        Document document = new Document();
        document.append("name", name);
        document.append("types", types);
        document.append("caption", caption);
        return document;
    }
}
