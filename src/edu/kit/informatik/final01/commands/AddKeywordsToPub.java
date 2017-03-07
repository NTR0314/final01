package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;

public class AddKeywordsToPub extends Command {
    /**
     * Konstruktor des Kommandos "add keywords to pub"
     */
    AddKeywordsToPub() {
        super(RegexConstant.ADD_KEYWORDS_TO_PUB);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 4);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);

        String[] splitCutInput = cutInput.split("[;:]");

        String pubid = splitCutInput[0];

        if (!literatureManager.getArticleList().contains(pubid)) {
            Terminal.printError("Publication " + pubid + " not found!");
            return;
        }

            for (int i = 1; i < splitCutInput.length; i++) {
                literatureManager.getArticleList().getArticle(pubid).getKeywordList().addKeyword(splitCutInput[i]);
            }


        Terminal.printLine("Ok");

    }
}
