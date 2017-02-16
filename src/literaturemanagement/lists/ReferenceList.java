package literaturemanagement.lists;

import literaturemanagement.entities.Article;

public class ReferenceList {
    private ArticleList articleList = new ArticleList();

    public ArticleList getArticleList() {
        return articleList;
    }

    public boolean contains(Article article) {
        return this.articleList.contains(article);

    }
}
