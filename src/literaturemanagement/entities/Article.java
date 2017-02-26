package literaturemanagement.entities;

import literaturemanagement.lists.ArticleList;
import literaturemanagement.lists.AuthorList;
import literaturemanagement.lists.KeywordList;
import literaturemanagement.lists.ReferenceList;

public class Article implements Comparable<Article>{
    private final String identifier; //besteht aus kleinbuchstaben udn Zahlen
    private final String title;
    private final int year;
    private final AuthorList authorList = new AuthorList();
    private final ReferenceList references = new ReferenceList();
    private final KeywordList keywordList = new KeywordList();
    private final Venue venue;


    public Article(String identifier, String title, int year, Venue venue) {
        this.identifier = identifier;
        this.title = title;
        this.year = year;
        this.venue = venue;
    }

    public AuthorList getAuthorList() {
        return authorList;
    }

    public String getIdentifier() {
        return identifier;
    }

    public ArticleList getReferences() {
        return references.getArticleList();
    }

    public KeywordList getKeywordList() {
        return keywordList;
    }

    public boolean isValid() {
        return !this.getAuthorList().getAuthorList().isEmpty();
    }

    public int getYear() {
        return year;
    }

    public Venue getVenue() {
        return venue;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return identifier;
    }

    public boolean contains(Author author) {
        for (int i = 0; i < this.authorList.getLength(); i++) {
            if (this.authorList.getAtIndex(i).getIdentifier().equals(author.getIdentifier())) {
                return true;
            }

        }

        return false;
    }

    public void addKeyword(String keyword) {
        this.keywordList.addKeyword(keyword);
    }

    public void addKeywords(KeywordList keywords) {
        for (int i = 0; i < keywords.getLength(); i++) {
            this.addKeyword(keywords.getAtIndex(i));
        }
    }

    @Override
    public int compareTo(Article a2) {
        int shorterAuthorlistLength;

        if (this.getAuthorList().getLength() > a2.getAuthorList().getLength()) {
            shorterAuthorlistLength = a2.getAuthorList().getLength();
        } else shorterAuthorlistLength = this.getAuthorList().getLength();

        for (int i = 0; i < shorterAuthorlistLength; i++) {
            if (this.getAuthorList().getAtIndex(i).compareTo(a2.getAuthorList().getAtIndex(i)) != 0) {
                return this.getAuthorList().getAtIndex(i).compareTo(a2.getAuthorList().getAtIndex(i));
            }
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
