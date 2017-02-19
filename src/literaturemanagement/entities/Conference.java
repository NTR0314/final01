package literaturemanagement.entities;

import literaturemanagement.lists.ArticleList;

public class Conference {

    private final String seriesName;
    private final int year;
    private final String location;
    private ArticleList articles = new ArticleList();

    public Conference(String seriesName, int year, String location) {
        this.seriesName = seriesName;
        this.year = year;
        this.location = location;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public int getYear() {
        return year;
    }

    public boolean contains(String identifier) {
        return this.articles.contains(identifier);
    }

    public void add(Article article) {
        this.articles.add(article);
    }
}
