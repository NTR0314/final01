package literaturemanagement.system;

import edu.kit.informatik.Terminal;
import literaturemanagement.Article;
import literaturemanagement.Author;

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
}
