package literaturemanagement.commands;

import literaturemanagement.Author;
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

        String[] splitCutInput = cutInput.split(",|;");

        if (literatureManager.getArticleList().getArticle(splitCutInput[0]) != null) {
            for (int i = 0; i < splitCutInput.length - 1; i += 2) {
                Author tempAuthorToAdd = new Author(splitCutInput[i + 1], splitCutInput[i + 2]);
                literatureManager.getArticleList()
                        .getArticle(splitCutInput[0]).getAuthorList().addAuthor(tempAuthorToAdd);
            }
        }

    }
}
