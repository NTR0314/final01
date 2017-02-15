package literaturemanagement.entities;

import java.util.ArrayList;

public class Journal {

    private final String name;

    private final String publisher;

    private ArrayList<Article> articles = new ArrayList<>();

    public Journal(String name, String publisher) {
        this.name = name;
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }
}
