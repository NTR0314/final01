package edu.kit.informatik.final01.lists;

import edu.kit.informatik.final01.entities.Article;
import edu.kit.informatik.final01.entities.Author;

import java.util.ArrayList;

public class ArticleList {
    private final ArrayList<Article> articleList = new ArrayList<>();

    /**
     * @param identifier identifier des gesuchten Artikels
     * @return Gibt den gesuchten Artikel zurück
     */
    public Article getArticle(String identifier) {
        for (Article anArticleList : this.articleList) {
            if (anArticleList.getIdentifier().equals(identifier)) {
                return anArticleList;
            }
        }
        return null;
    }

    /**
     * @return Gibt die Länge der Liste zurück
     */
    public int getLength() {
        return this.articleList.size();
    }

    /**
     * Gibt den Artikel an einem bestimmten index zurück
     * @param index der index dessen Artikel zurückgegeben werden soll
     * @return der Artikel an dem Index
     */
    public Article getAtIndex(int index) {
        return this.articleList.get(index);
    }

    /**
     * Die Methode gibt alle artikel von einem autor zurück
     * @param author Der gesuchte Autor
     * @return Gibt identifier der vom Autor geschrieben Artikel in einer String-Array-List zurück
     */
    private ArrayList<String> getArticlesFrom(Author author) {
        ArrayList<String> idList = new ArrayList<>();


        for (Article anArticleList : this.articleList) {
            for (int j = 0; j < anArticleList.getAuthorList().getAuthorList().size(); j++) {
                if (anArticleList.getAuthorList().getAtIndex(j).compareTo(author) == 0) {
                    idList.add(anArticleList.getIdentifier());
                }

            }

        }

        return idList;
    }

    /**
     * Gibt alle Artikel von mehreren Autoren zurück
     * @param authorList Die Autoren nach dessen Artikel gesuchte werden soll
     * @return eine String ArrayList aus identifiern von den geschriebenen artikeln von den autoren
     */
    public ArrayList<String> getArticlesFrom(AuthorList authorList) {
        ArrayList<String> idList = new ArrayList<>();
        for (int i = 0; i < authorList.getLength(); i++) {
            for (int j = 0; j < this.getArticlesFrom(authorList.getAtIndex(i)).size(); j++) {
                if (!idList.contains(this.getArticlesFrom(authorList.getAtIndex(i)).get(j))) {
                    idList.add(this.getArticlesFrom(authorList.getAtIndex(i)).get(j));
                }
            }
        }

        return idList;
    }

    /**
     * Die Methode fügt der Liste einen Artikel hinzu
     * @param article Der Artikel der hinzugefügt werden soll
     */
    public void add(Article article) {
        this.articleList.add(article);
    }

    /**
     * Die Methode fügt der Liste eine Liste von Artikeln hinzu
     * @param articleList Die ArtikelListe die hinzugefügt werden soll
     */
    public void add(ArticleList articleList) {
        for (int i = 0; i < articleList.getLength(); i++) {
            this.add(articleList.getAtIndex(i));

        }
    }

    /**
     * Die Methode gibt alle ARtikel zurück die in einem gegeben Jahr publiziert worden sind
     * @param year das gesuchte Jahr
     * @return Eine ArtikelListe von allen gesuchten Artikeln
     */
    public ArticleList getAllInYear(int year) {
        ArticleList aL = new ArticleList();
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getYear() == year) {
                aL.add(this.getAtIndex(i));
            }
        }

        return aL;
    }

    /**
     *
     * @return gibt die Article ArrayList zurück die diese Liste enthält
     */
    public ArrayList<Article> getArticleList() {
        return articleList;
    }

    /**
     * Die Methode gibt alle Artikel zurück, die ein gegebenes Keyword enthalten
     * @param keyword Das Keyword nach dem gesucht werden soll
     * @return Eine ArtikelListe von den gesuchten Artikeln
     */
    public ArticleList getWithKeyword(String keyword) {
        ArticleList newArticleListContainingKeywords = new ArticleList();

        for (int i = 0; i < this.getLength(); i++) {
            if (this.articleList.get(i).getKeywordList().contains(keyword)) {
                newArticleListContainingKeywords.add(this.articleList.get(i));
            }

        }

        return newArticleListContainingKeywords;
    }

    /**
     * Die Methode gibt alle Artikel mit mehreren gescuhten keywords zurück
     * @param keywordList mehrere gescuhte Keywords
     * @return Die gesuchte Artikel in einer Artikel Liste
     */
    public ArticleList getWithKeywords(KeywordList keywordList) {
        ArticleList newArticleListContainingKeywords = this.getWithKeyword(keywordList.getAtIndex(0));

        for (int i = 1; i < keywordList.getLength(); i++) {
            newArticleListContainingKeywords
                    = newArticleListContainingKeywords.getWithKeyword(keywordList.getAtIndex(i));
        }

        return newArticleListContainingKeywords;
    }

    /**
     * Die Methode gibt alle Artikel zurück die von einem bestimmten Autor geschrieben wurden sind
     * @param author Der gesuchte Autor
     * @return Die gescuchten Aritkel in einer ArtikelListe
     */
    public ArticleList getByAuthor(Author author) {
        ArticleList newAL = new ArticleList();

        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getAuthorList().contains(author)) {
                newAL.add(this.getAtIndex(i));
            }

        }

        return newAL;
    }

    /**
     * Die Methode checkt ob ein bestimmter Artikel in dieser ArtikelListe vorhanden ist
     * @param article Der gesuchte Artikel
     * @return true, falls vorhanden
     *          false, sonst
     */
    public boolean contains(Article article) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getIdentifier().equals(article.getIdentifier())) {
                return true;
            }

        }

        return false;
    }

    /**
     * Die Methode überprüft ob ein Artikel in dieser ArtikelListe vorhanden ist
     * @param id der identifier des gesuchten Artikels
     * @return true, falls vorhanden
     *          false, sonst
     */
    public boolean contains(String id) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getIdentifier().equals(id)) {
                return true;
            }

        }

        return false;
    }

    /**
     * Die Methode gibt alle Artikel zurück die nicht von einem bestimmten Autor geschrieben worden sind
     * @param author der gesuchte Autor
     * @return eine ArtikelListe mit den gesuchten Artikeln
     */
    public ArticleList notWrittenBy(Author author) {
        ArticleList newArticleList = new ArticleList();
        for (int i = 0; i < this.getLength(); i++) {
            if (!this.getAtIndex(i).getAuthorList().contains(author)) {
                newArticleList.add(this.getAtIndex(i));
            }

        }

        return newArticleList;
    }

    /**
     * Die Methode gibt alle Artikel zurück die nicht von mehreren bestimmten Autoren geschrieben worden sind
     * @param authorList die gesuchten Autoren in einer AutorenListe
     * @return Die gesuchten Artikel in einer ArtikelListe
     */
    public ArticleList notWrittenBy(AuthorList authorList) {
        ArticleList newArticleList = this;
        for (int i = 0; i < authorList.getLength(); i++) {
            newArticleList = newArticleList.notWrittenBy(authorList.getAtIndex(i));

        }

        return newArticleList;
    }

    /**
     * Die Methode gibt alle Artikel zurück auf die ein Artikel referenziert
     * @param article der Artikel von dem referenziert wird
     * @return Die gesuchten Artikel in einer ArtikelListe
     */
    private ArticleList hasReferenceOn(Article article) {
        ArticleList newArticleList = new ArticleList();
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getReferences().contains(article)) {
                newArticleList.add(this.getAtIndex(i));

            }

        }

        return newArticleList;
    }

    /**
     * Die Methode fügt zwei ArtikelListen zusammen, so dass in der neuen keine Duplikate vorhanden sind
     * @param articleList die andere ArtikelListe die hinzugefügt werden soll
     * @return eine neue ArtikelListe die aus beiden ArtikelListen besteht nur ohne Duplikate
     */
    private ArticleList addWithoutDuplicates(ArticleList articleList) {
        ArticleList newArticleList = this;
        for (int i = 0; i < articleList.getLength(); i++) {
            if (!this.contains(articleList.getAtIndex(i))) {
                newArticleList.add(articleList.getAtIndex(i));
            }

        }

        return newArticleList;
    }

    /**
     * Die Methode gibt alle Artikel zurück die von Mehreren Artikeln referenziert werden
     * @param articleList die mehrere Artikel von den referenziert wird
     * @return die gesuchten Artikel in einer ArtikelListe
     */
    public ArticleList hasReferenceOn(ArticleList articleList) {
        ArticleList newArticleList = new ArticleList();
        for (int i = 0; i < articleList.getLength(); i++) {
            newArticleList = newArticleList.addWithoutDuplicates(this.hasReferenceOn(articleList.getAtIndex(i)));

        }

        return newArticleList;
    }
}
