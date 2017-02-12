package literaturemanagement;

import literaturemanagement.venues.Conference;

import java.util.ArrayList;

public class ConferenceSeries {
    private ArrayList<Conference> conferences;
    private ArrayList<Article> articles;

    private final String name;

    private ArrayList<String> keywords;

    public ConferenceSeries(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addArticle(Article article) {
        this.articles.add(article);
    }
}
