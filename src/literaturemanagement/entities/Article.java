package literaturemanagement.entities;

import literaturemanagement.lists.ArticleList;
import literaturemanagement.lists.AuthorList;
import literaturemanagement.lists.KeywordList;
import literaturemanagement.lists.ReferenceList;

public class Article {
    private final String identifier; //besteht aus kleinbuchstaben udn Zahlen
    private final String title;
    private final int year;
    private AuthorList authorList = new AuthorList();
    private ReferenceList references = new ReferenceList();
    private KeywordList keywordList = new KeywordList();


    public Article(String identifier, String title, int year) {
        this.identifier = identifier;
        this.title = title;
        this.year = year;
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
        if (this.getAuthorList().getAuthorList().isEmpty()) {
            return false;
        }

        return true;
    }

    public int getYear() {
        return year;
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
}
