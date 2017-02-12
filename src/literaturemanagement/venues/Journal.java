package literaturemanagement.venues;

import literaturemanagement.Article;

import java.util.ArrayList;

public class Journal {

    private final String name;

    private final String publisher;

    private ArrayList<Article> articles;

    public Journal(String name, String publisher) {
        this.name = name;
        this.publisher = publisher;
    }
}
