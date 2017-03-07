package edu.kit.informatik.final01.entities;

import edu.kit.informatik.final01.lists.ArticleList;
import edu.kit.informatik.final01.lists.KeywordList;

public class Conference {

    private final String seriesName;
    private final int year;
    private final String location;
    private final ArticleList articles = new ArticleList();
    private final KeywordList keywords = new KeywordList();

    /**
     * Konstruktor für eine Koferenz
     * @param seriesName Der Name der angehörigen Konferenz-Serie
     * @param year Das Jahr der Konferenz
     * @param location Der Ort der Konferenz
     */
    public Conference(String seriesName, int year, String location) {
        this.seriesName = seriesName;
        this.year = year;
        this.location = location;
    }

    /**
     * @return Gibt den Namen der angehörigen Konferenz-Serie zurück
     */
    public String getSeriesName() {
        return seriesName;
    }

    /**
     * @return Gibt das Jahr der Konferenz zurück
     */
    public int getYear() {
        return year;
    }

    /**
     * @return Gibt den Ort der Konferenz zurück
     */
    public String getLocation() {
        return location;
    }

    /**
     * Die Methode checkt ob ein bestimmter Artikel in dieser Konferenz enthalten ist
     * @param identifier Der identifier des gesuchten Artikels
     * @return true, falls vorhanden
     *         false, sonst
     */
    public boolean contains(String identifier) {
        return this.articles.contains(identifier);
    }

    /**
     * Die Methode fügt der Konferenz einen Artikel hinzu
     * @param article Der Artikel der hinzugefügt werden soll
     */
    public void add(Article article) {
        this.articles.add(article);

        article.addKeywords(this.keywords);
    }

    /**
     * Die Methode fügt der Konferenz und auch deren Artikel ein Keyword hinzu
     * @param keyword Das keyword das hinzugefügt werden soll
     */
    public void addKeyword(String keyword) {
        this.keywords.addKeyword(keyword);

        for (int i = 0; i < this.articles.getLength(); i++) {
            this.articles.getAtIndex(i).addKeyword(keyword);
        }
    }

    /**
     * Die Methode fügt der Konferenz und auch deren Artikel eine Liste an Keywords hinzu
     * @param keywords Die Liste an Keywords die hinzugefügt werden soll
     */
    void addKeywords(KeywordList keywords) {
        for (int i = 0; i < keywords.getLength(); i++) {
            this.addKeyword(keywords.getAtIndex(i));
        }
    }

    /**
     * Die Methode gibt alle Artikel die in einem bestimmten Jahr publiziert wurden und in dieser Konferenz sind zurück
     * @param year Das gesuchte Jahr
     * @return alle Artikel die im gegebenen Jahr publiziert wurden und in dieser Konferenz sind in Form einer
     * ArtikelListe
     */
    public ArticleList getAtYear(int year) {
        return this.articles.getAllInYear(year);
    }
}
