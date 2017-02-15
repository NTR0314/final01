package literaturemanagement.entities;

import literaturemanagement.lists.AuthorList;
import literaturemanagement.lists.KeywordList;

import java.util.ArrayList;

public class Article {
    private final String identifier; //besteht aus kleinbuchstaben udn Zahlen
    private final String title;
    private final int year;
    private AuthorList authorList = new AuthorList();
    private ArrayList<Article> references = new ArrayList<>();
    private KeywordList keywordList = new KeywordList();


    public Article(String identifier, String title, int year) {
        this.identifier = identifier;
        this.title = title;
        this.year = year;
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

    public KeywordList getKeywordList() {
        return keywordList;
    }

    public boolean isValid() {
        if (this.getAuthorList().getAuthorList().isEmpty()) {
            return false;
        }

        return true;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return identifier;
    }
}
