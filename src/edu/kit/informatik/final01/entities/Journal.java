package edu.kit.informatik.final01.entities;

import edu.kit.informatik.final01.lists.ArticleList;
import edu.kit.informatik.final01.lists.KeywordList;

public class Journal extends Venue {
    private final String publisher;
    private final ArticleList articles = new ArticleList();
    private final KeywordList keywords = new KeywordList();

    /**
     * Konstruktor für ein Journal
     * @param name Der Name des Journals
     * @param publisher Der Name des Verlegers des Journals
     */
    public Journal(String name, String publisher) {
        super(name);
        this.publisher = publisher;
    }

    /**
     * @return gibt den Namen des Journals zurück
     */
    public String getName() {
        return name;
    }

    /**
     * Die Methode überprüft ob ein das Journal einen Artikel enthält
     * @param id Der Identifier des zu suchenden Artikels
     * @return wahr, falls der gesuchte Artikel vorhanden ist
     *         falsch, sonst
     */
    public boolean contains(String id) {
        return this.articles.contains(id);
    }

    /**
     * Die Methode fügt einen Artikel zu dem Journal hinzu
     * @param article Der Artikel der hinzugefügt werden soll
     */
    public void add(Article article) {
        this.articles.add(article);

        article.addKeywords(this.keywords);
    }

    /**
     * Die Methode fügt ein Schlüsseslwort zu dem Journal hinzu
     * @param keyword das Schlüsselwort das hinzugefügt werden soll
     */
    public void addKeyword(String keyword) {
        this.keywords.addKeyword(keyword);

        for (int i = 0; i < this.articles.getLength(); i++) {
            this.articles.getAtIndex(i).addKeyword(keyword);
        }
    }
}
