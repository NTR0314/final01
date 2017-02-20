package literaturemanagement.entities;

import literaturemanagement.lists.ArticleList;
import literaturemanagement.lists.KeywordList;

public class Conference {

    private final String seriesName;
    private final int year;
    private final String location;
    private ArticleList articles = new ArticleList();
    private KeywordList keywords = new KeywordList();

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

        article.addKeywords(this.keywords);
    }

    public void addKeyword(String keyword) {
        this.keywords.addKeyword(keyword);

        for (int i = 0; i < this.articles.getLength(); i++) {
            this.articles.getAtIndex(i).addKeyword(keyword);
        }
    }

    public void addKeywords(KeywordList keywords) {
        for (int i = 0; i < keywords.getLength(); i++) {
            this.addKeyword(keywords.getAtIndex(i));
        }
    }

    public ArticleList getArticles() {
        return articles;
    }

    public ArticleList getAtYear(int year) {
        return this.articles.getAllInYear(year);
    }
}
