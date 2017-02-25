package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.LiteratureManager;
import literaturemanagement.entities.Article;

public class PrintBibliographyIEEE extends Command {
    protected PrintBibliographyIEEE() {
        super(RegexConstant.PRINT_BIBLIPGRAPHY_IEEE);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 2);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutString = cutString(input);

        String[] splitCutString = cutString.split(";|:");

        for (int i = 1; i < splitCutString.length; i++) {
            if (!literatureManager.getArticleList().contains(splitCutString[i])
                    || !literatureManager.getArticleList().getArticle(splitCutString[i]).isValid()) {
                Terminal.printError("One of the Articles is either invalid or does not exist!");
            }
        }

        for (int i = 1; i < splitCutString.length; i++) {
            Article article = literatureManager.getArticleList().getArticle(splitCutString[i]);


        }
    }
}
