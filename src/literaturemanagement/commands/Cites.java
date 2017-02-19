package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.entities.Article;
import literaturemanagement.LiteratureManager;

public class Cites extends Command {
    protected Cites() {
        super(RegexConstant.CITES);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 1);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);
        String[] splitCutInput = cutInput.split(",");

        String id1 = splitCutInput[0];
        String id2 = splitCutInput[1];
        int year1 = literatureManager.getArticleList().getArticle(id1).getYear();
        int year2 = literatureManager.getArticleList().getArticle(id2).getYear();

        if (literatureManager.getArticleList().getArticle(id1) == null) {
            Terminal.printError("First Article not found");
            return;
        }

        if (literatureManager.getArticleList().getArticle(id2) == null) {
            Terminal.printError("Second Article not found");
            return;
        }

        if (year1 <= year2) {
            Terminal.printError("Can not reference to an Article from same or higher year!");
            return;
        }

        Article articleToAdd = literatureManager.getArticleList().getArticle(id2);

        literatureManager.getArticleList().getArticle(id1).getReferences().add(articleToAdd);
        Terminal.printLine("Ok");

    }
}
