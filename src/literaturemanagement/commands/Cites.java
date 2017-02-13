package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.Article;
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

        if (literatureManager.getArticleList().getArticle(id1) == null) {
            Terminal.printError("First Article not found");
            return;
        }

        if (literatureManager.getArticleList().getArticle(id2) == null) {
            Terminal.printError("Second Article not found");
            return;
        }

        Article articleToAdd = literatureManager.getArticleList().getArticle(id2);

        literatureManager.getArticleList().getArticle(id1).getReferences().add(articleToAdd);

    }
}
