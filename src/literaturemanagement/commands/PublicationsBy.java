package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.Author;
import literaturemanagement.LiteratureManager;

public class PublicationsBy extends Command {
    protected PublicationsBy() {
        super(RegexConstant.PUBLICATIONS_BY);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 2);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutString = cutString(input);
        String[] splitCutString = cutString.split(" |;");

        for (int i = 0; i < splitCutString.length; i += 2) {
            Author author = new Author(splitCutString[i], splitCutString[i+1]);
            Terminal.printLine(literatureManager.getArticleList().getArticlesFrom(author));

        }

    }
}
