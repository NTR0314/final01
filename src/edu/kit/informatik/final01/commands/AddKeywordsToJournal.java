package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.entities.Journal;

public class AddKeywordsToJournal extends Command {
    /**
     * Konstruktor des Kommandos "add keywords to journal"
     */
    AddKeywordsToJournal() {
        super(RegexConstant.ADD_KEYWORDS_TO_JOURNAL);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 4);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);

        String[] cutSplitInput = cutInput.split("[;:]");

        String journalName = cutSplitInput[0];

        if (!literatureManager.getJournalList().contains(journalName)) {
            Terminal.printError("Journal " + journalName + " not found!");
        }

        Journal j = literatureManager.getJournalList().getJournal(journalName);

        for (int i = 1; i < cutSplitInput.length; i++) {
            j.addKeyword(cutSplitInput[i]);
        }

        Terminal.printLine("Ok");

    }
}
