package literaturemanagement.entities;

import literaturemanagement.lists.ArticleList;
import literaturemanagement.lists.KeywordList;

public class Journal {

    private final String name;
    private final String publisher;
    private ArticleList articles = new ArticleList();
    private KeywordList keywords = new KeywordList();

    public Journal(String name, String publisher) {
        this.name = name;
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public boolean contains(String id) {
        return this.articles.contains(id);
    }

    public void add(Article article) {
        this.articles.add(article);
    }

    public void addKeywords(String keyword) {
        this.keywords.addKeyword(keyword);

        for (int i = 0; i < this.articles.getLength(); i++) {
            this.articles.getAtIndex(i).addKeyword(keyword);
        }
    }
}
