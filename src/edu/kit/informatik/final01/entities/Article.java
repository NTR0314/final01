package edu.kit.informatik.final01.entities;

import edu.kit.informatik.final01.lists.ArticleList;
import edu.kit.informatik.final01.lists.AuthorList;
import edu.kit.informatik.final01.lists.KeywordList;
import edu.kit.informatik.final01.lists.ReferenceList;

public class Article implements Comparable<Article> {
    private final String identifier;
    private final String title;
    private final int year;
    private final AuthorList authorList = new AuthorList();
    private final ReferenceList references = new ReferenceList();
    private final KeywordList keywordList = new KeywordList();
    private final Venue venue;

    /**
     * Konstruktor eines Artikels
     * @param identifier Der Identifier des Artikels, der sich nur aus Kleinbuchstaben und Zahlen zusammensetzt
     * @param title Der Titel des Artikels
     * @param year Das Jahr an dem der Artikel veröffentlicht wurde
     * @param venue Der Publikationsort
     */
    public Article(String identifier, String title, int year, Venue venue) {
        this.identifier = identifier;
        this.title = title;
        this.year = year;
        this.venue = venue;
    }

    /**
     * @return Gibt die Autorenliste des Artikels zurück
     */
    public AuthorList getAuthorList() {
        return authorList;
    }

    /**
     * @return Gibt den Identifier des Artikels zurück
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @return gibt die Artikel auf denen der Artikel referenziert zurück
     */
    public ArticleList getReferences() {
        return references.getArticleList();
    }

    /**
     * @return Gibt die Schlüsselwort-Liste des Artikels zurück
     */
    public KeywordList getKeywordList() {
        return keywordList;
    }

    /**
     * @return gibt zurück ob der Artikel gültig ist, also ob mind. 1 Autor in der Autorenliste ist
     */
    public boolean isValid() {
        return !this.getAuthorList().getAuthorList().isEmpty();
    }

    /**
     * @return gibt das Jahr zurück in dem der Artikel veröffentlicht wurde
     */
    public int getYear() {
        return year;
    }

    /**
     * @return gibt den Publikationsort zurück an dem der Artikel veröffentlicht wurde (Journal/Conference)
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     * @return gibt den Titel des Artikels zurück
     */
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return identifier;
    }

    /**
     * Die Methode sagt ob der Artikel einen bestimmten Autor als Autor enthält
     * @param author Der Autor nach dem gesucht wird
     * @return wahr, falls der Autor enthalten ist
     *         falsch, sonst
     */
    public boolean contains(Author author) {
        for (int i = 0; i < this.authorList.getLength(); i++) {
            if (this.authorList.getAtIndex(i).getIdentifier().equals(author.getIdentifier())) {
                return true;
            }

        }

        return false;
    }

    /**
     * Die Methode fügt ein Schlüsselwort zu dem Artikel hinzu
     * @param keyword das Schlüsselwort das hinzugefügt werden soll
     */
    public void addKeyword(String keyword) {
        this.keywordList.addKeyword(keyword);
    }

    /**
     * Die Methode fügt eine Liste von Schlüsselwörten dem Artikel hinzu
     * @param keywords Die Liste an Schlüsselwörtern die hinzugefügt werden soll
     */
    public void addKeywords(KeywordList keywords) {
        for (int i = 0; i < keywords.getLength(); i++) {
            this.addKeyword(keywords.getAtIndex(i));
        }
    }

    @Override
    public int compareTo(Article a2) {
        int shorterAuthorList;

        if (this.getAuthorList().getLength() > a2.getAuthorList().getLength()) {
            shorterAuthorList = a2.getAuthorList().getLength();
        } else shorterAuthorList = this.getAuthorList().getLength();

        for (int i = 0; i < shorterAuthorList; i++) {
            if (this.getAuthorList().getAtIndex(i).compareTo(a2.getAuthorList().getAtIndex(i)) != 0) {
                    return this.getAuthorList().getAtIndex(i).compareTo(a2.getAuthorList().getAtIndex(i));
            }
        }

        if (this.getAuthorList().getLength() > a2.getAuthorList().getLength()) {
            return 1;
        }

        if (this.getAuthorList().getLength() < a2.getAuthorList().getLength()) {
            return -1;
        }

        if (this.title.compareTo(a2.title) != 0) {
            return this.title.compareTo(a2.title);
        } else if (this.year != a2.year) {
            if (this.year > a2.year) {
                return 1;
            } else if (a2.year > this.year) {
                return -1;
            }
        } else if (this.identifier.compareTo(a2.identifier) != 0) {
            return this.identifier.compareTo(a2.identifier);
        }

        return 0;

    }


}
