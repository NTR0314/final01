package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.entities.Article;
import literaturemanagement.entities.Author;
import literaturemanagement.LiteratureManager;

public class WrittenBy extends Command {
    protected WrittenBy() {
        super(RegexConstant.WRITTEN_BY);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 1);
    }


    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);

        String[] splitCutInput = cutInput.split(",|;| ");

        String articleName = splitCutInput[0];
        Article article = literatureManager.getArticleList().getArticle(articleName);

        if (!literatureManager.getArticleList().contains(articleName)) {
            Terminal.printError("Article not existing!");
            return;
        }

        for (int i = 0; i < splitCutInput.length - 2; i += 2) {
            Author tempAuthorToAdd = new Author(splitCutInput[i + 1], splitCutInput[i + 2]);
            if (!literatureManager.getAuthorList().contains(tempAuthorToAdd)) {
                Terminal.printError("Author " + tempAuthorToAdd.getName() + " " + tempAuthorToAdd.getLastName() +
                 " does not exist!");
                return;
            }

        }



        for (int i = 0; i < splitCutInput.length - 2; i += 2) {
            Author tempAuthorToAdd = new Author(splitCutInput[i + 1], splitCutInput[i + 2]);
            if (article.getAuthorList().contains(tempAuthorToAdd)) {
                Terminal.printError("Author " + tempAuthorToAdd.getName() + " " +
                        tempAuthorToAdd.getLastName() + " is already Author of the Article!");
                return;
            }

        }


        for (int i = 0; i < splitCutInput.length - 2; i += 2) {
            Author tempAuthorToAdd = new Author(splitCutInput[i + 1], splitCutInput[i + 2]);
            article.getAuthorList().addAuthor(tempAuthorToAdd);
        }


        Terminal.printLine("Ok");

    }
}
