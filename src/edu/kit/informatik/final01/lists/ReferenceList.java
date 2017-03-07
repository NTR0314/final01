package edu.kit.informatik.final01.lists;

import edu.kit.informatik.final01.entities.Article;

public class ReferenceList {
    private final ArticleList articleList = new ArticleList();

    /**
     * @return gibt die Artikelliste zurück, welche die Referenzen darstellt.
     */
    public ArticleList getArticleList() {
        return articleList;
    }

    /**
     * Die Methode überprüft ob ein bestimmter Artikel in dieser Referenz-Liste vorhanden ist.
     * @param article der gesuchte Artikel
     * @return true, falls vorhanden.
     *         false, sonst.
     */
    public boolean contains(Article article) {
        return this.articleList.contains(article);

    }
}
