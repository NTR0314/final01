package literaturemanagement;

import literaturemanagement.system.ArticleList;
import literaturemanagement.venues.Conference;

import java.util.ArrayList;

public class ConferenceSeries {
    private ArrayList<Conference> conferences;
    private ArticleList articles;
    private final String name;
    private ArrayList<String> keywords;

    public ConferenceSeries(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Article> getArticleArrayList() {
        return this.articles.getArticleList();
    }

    public ArticleList getArticles() {
        return articles;
    }
}
