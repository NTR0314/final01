package literaturemanagement.entities;

import literaturemanagement.lists.ArticleList;

public class Journal {

    private final String name;
    private final String publisher;
    private ArticleList articles = new ArticleList();

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
}
