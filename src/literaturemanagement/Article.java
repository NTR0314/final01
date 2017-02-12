package literaturemanagement;

import java.util.ArrayList;

public class Article {
    private final String identifier; //besteht aus kleinbuchstaben udn Zahlen
    private final String title;
    private final int yearOfPublication;
    private ArrayList<Author> authors = new ArrayList<>();
    private ArrayList<Article> references = new ArrayList<>();


    public Article(String identifier, String title, int yearOfPublication) {
        this.identifier = identifier;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

}
