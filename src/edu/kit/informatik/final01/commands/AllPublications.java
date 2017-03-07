package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;

public class AllPublications extends Command {
    /**
     * Konstruktor des Kommandos "all publications"
     */
    AllPublications() {
        super(RegexConstant.ALL_PUBLICATIONS);
    }

    @Override
    public String cutString(String input) {
        return input;
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        for (int i = 0; i < literatureManager.getArticleList().getLength(); i++) {
                Terminal.printLine(literatureManager.getArticleList().getAtIndex(i).getIdentifier());
        }

    }
}
