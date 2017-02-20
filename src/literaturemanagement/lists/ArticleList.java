package literaturemanagement.lists;

import edu.kit.informatik.Terminal;
import literaturemanagement.entities.Article;
import literaturemanagement.entities.Author;

import java.util.ArrayList;

public class ArticleList {
    private ArrayList<Article> articleList = new ArrayList<>();

    public Article getArticle(String identifier) {
        for (int i = 0; i < this.articleList.size(); i++) {
            if (this.articleList.get(i).getIdentifier().equals(identifier)) {
                return this.articleList.get(i);
            }
        }
        return null;
    }

    public int getLength() {
        return this.articleList.size();
    }

    public Article getAtIndex(int index) {
        return this.articleList.get(index);
    }


    public ArrayList<String> getArticlesFrom(Author author) {
        ArrayList<String> idList = new ArrayList<>();


        for (int i = 0; i < this.articleList.size(); i++) {
            for (int j = 0; j < this.articleList.get(i).getAuthorList().getAuthorList().size(); j++) {
                if (this.articleList.get(i).getAuthorList().getAtIndex(j).compareTo(author) == 0) {
                    idList.add(this.articleList.get(i).getIdentifier());
                }

            }

        }

        return idList;
    }

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

    public void add(Article article) {
        this.articleList.add(article);
    }

    public void add(ArticleList articleList) {
        for (int i = 0; i < articleList.getLength(); i++) {
            this.add(articleList.getAtIndex(i));

        }
    }

    public ArticleList getAllInYear(int year) {
        ArticleList aL = new ArticleList();
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getYear() == year) {
                aL.add(this.getAtIndex(i));
            }
        }

        return aL;
    }

    public ArrayList<Article> getArticleList() {
        return articleList;
    }

    public ArticleList getWithKeyword(String keyword) {
        ArticleList newArticleListContainingKeywords = new ArticleList();

        for (int i = 0; i < this.getLength(); i++) {
            if (this.articleList.get(i).getKeywordList().contains(keyword)) {
                newArticleListContainingKeywords.add(this.articleList.get(i));
            }

        }

        return newArticleListContainingKeywords;
    }

    public ArticleList getWithKeywords(KeywordList keywordList) {
        ArticleList newArticleListContainingKeywords = this.getWithKeyword(keywordList.getAtIndex(0));

        for (int i = 1; i < keywordList.getLength(); i++) {
            newArticleListContainingKeywords = newArticleListContainingKeywords.getWithKeyword(keywordList.getAtIndex(i));
        }

        return newArticleListContainingKeywords;
    }

    public ArticleList getByAuthor(Author author) {
        ArticleList newAL = new ArticleList();

        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getAuthorList().contains(author)) {
                newAL.add(this.getAtIndex(i));
            }

        }

        return newAL;
    }

    public boolean contains(Article article) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getIdentifier().equals(article.getIdentifier())) {
                return true;
            }

        }

        return false;
    }

    public boolean contains(String id) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getIdentifier().equals(id)) {
                return true;
            }

        }

        return false;
    }

    public ArticleList notWrittenBy(Author author) {
        ArticleList newArticleList = new ArticleList();
        for (int i = 0; i < this.getLength(); i++) {
            if (!this.getAtIndex(i).getAuthorList().contains(author)) {
                newArticleList.add(this.getAtIndex(i));
            }

        }

        return newArticleList;
    }

    public ArticleList notWrittenBy(AuthorList authorList) {
        ArticleList newArticleList = this;
        for (int i = 0; i < authorList.getLength(); i++) {
            newArticleList = newArticleList.notWrittenBy(authorList.getAtIndex(i));

        }

        return newArticleList;
    }

    public ArticleList hasReferenceOn(Article article) {
        ArticleList newArticleList = new ArticleList();
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getReferences().contains(article)) {
                newArticleList.add(this.getAtIndex(i));

            }

        }

        return newArticleList;
    }

    public ArticleList addWithoutDuplicates(ArticleList articleList) {
        ArticleList newArticleList = this;
        for (int i = 0; i < articleList.getLength(); i++) {
            if (!this.contains(articleList.getAtIndex(i))) {
                newArticleList.add(articleList.getAtIndex(i));
            }

        }

        return newArticleList;
    }

    public ArticleList hasReferenceOn(ArticleList articleList) {
        ArticleList newArticleList = new ArticleList();
        for (int i = 0; i < articleList.getLength(); i++) {
            newArticleList = newArticleList.addWithoutDuplicates(this.hasReferenceOn(articleList.getAtIndex(i)));

        }

        return newArticleList;
    }
}
