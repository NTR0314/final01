package literaturemanagement.system;

import edu.kit.informatik.Terminal;
import literaturemanagement.Article;

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
}
