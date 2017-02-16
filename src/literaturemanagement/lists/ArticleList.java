package literaturemanagement.lists;

import edu.kit.informatik.Terminal;
import literaturemanagement.entities.Article;
import literaturemanagement.entities.Author;

import java.util.ArrayList;

public class ArticleList {
    private ArrayList<Article> articleList = new ArrayList<>();

    public Article getArticle(String identifier) {
        for (int i = 0; i < this.articleList.size(); i++) {
            if (this.articleList.get(i).getIdentifier() == identifier) {
                return this.articleList.get(i);
            }
        }

        Terminal.printError("Article not found");
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

    public void add(Article article) {
        this.articleList.add(article);
    }

    public void add(ArticleList articleList) {
        for (int i = 0; i < articleList.getLength(); i++) {
            this.add(articleList.getAtIndex(i));

        }
    }

    public void printAllInYear(int year) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getYear() == year) {
                Terminal.printLine(this.getAtIndex(i).getIdentifier());
            }
        }
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
        ArticleList newArticleListContainingKeywords = new ArticleList();

        for (int i = 0; i < keywordList.getLength(); i++) {
            newArticleListContainingKeywords.add(getWithKeyword(keywordList.getAtIndex(i)));
        }

        return newArticleListContainingKeywords;
    }

    public String toString() {
        if (this.getLength() == 0) {
            return "";
        }

        String tempString = this.getAtIndex(0).toString();

        for (int i = 1; i < this.getLength(); i++) {
            tempString = tempString + "\n" + this.getAtIndex(i).toString();

        }

        return tempString;
    }

    public ArticleList getByAuthor(Author author) {
        ArticleList newAL = new ArticleList();

        for (int i = 0; i < this.getLength(); i++) {
            if(this.getAtIndex(i).getAuthorList().contains(author)) {
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
}
