package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.entities.Article;
import edu.kit.informatik.final01.entities.Journal;

public class AddArticleToJournal extends Command {
    /**
     * Konstruktor des Kommandos "add article to journal"
     */
    AddArticleToJournal() {
        super(RegexConstant.ADD_ARTICLE_TOO_JOURNAL);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 4);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);

        String[] splittedCutInput = cutInput.split("[,:]", 4);

        String seriesName = splittedCutInput[0];
        String articleName = splittedCutInput[1];
        int year = Integer.parseInt(splittedCutInput[2]);
        String articleTitle = splittedCutInput[3];

        if (!literatureManager.getJournalList().contains(seriesName)) {
            Terminal.printError("Journal not found!");
            return;
        }
        Journal j = literatureManager.getJournalList().getJournal(seriesName);

        Article articleToAdd = new Article(articleName, articleTitle, year, j);

        if (literatureManager.getJournalList().getJournal(seriesName).contains(articleName)) {
            Terminal.printError("This Article already exists in the Journal " + seriesName + "!");
        } else {
            j.add(articleToAdd);
            literatureManager.getArticleList().add(articleToAdd);
            Terminal.printLine("Ok");
        }
    }
}
