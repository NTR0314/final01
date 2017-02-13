package literaturemanagement;

import literaturemanagement.system.AuthorList;

import java.util.ArrayList;

public class Article {
    private final String identifier; //besteht aus kleinbuchstaben udn Zahlen
    private final String title;
    private final int yearOfPublication;
    private AuthorList authorList = new AuthorList();
    private ArrayList<Article> references = new ArrayList<>();


    public Article(String identifier, String title, int yearOfPublication) {
        this.identifier = identifier;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public AuthorList getAuthorList() {
        return authorList;
    }

    public String getIdentifier() {
        return identifier;
    }

    public ArrayList<Article> getReferences() {
        return references;
    }
}
