package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.MyUtil;

public class DirectPrintJournalIEEE extends Command {
    /**
     * Konstruktor des Kommandos "direct print journal ieee"
     */
    DirectPrintJournalIEEE() {
        super(RegexConstant.DIRECT_PRINT_JOURNAL_IEEE);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 3);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {

        String cutString = cutString(input);

        String[] splitCutString = cutString.split("[:,]");

        String author1[] = splitCutString[1].split(" ");
        String author1Abr = String.valueOf(author1[0].charAt(0)).toUpperCase() + ". " + author1[1];

        String title = splitCutString[4];
        String journalTitle = splitCutString[5];
        String year = splitCutString[6];

        if (!MyUtil.isValidYear(year)) {
            Terminal.printError("Invalid Year!");
            return;
        }

        if (splitCutString[2].isEmpty() && splitCutString[3].isEmpty()) {

            Terminal.printLine("[1] " + author1Abr + ", \"" + title + ",\" "
                    + journalTitle + ", " + year + ".");

        } else if (splitCutString[3].isEmpty()) {

            String author2[] = splitCutString[2].split(" ");
            String author2Abr = String.valueOf(author2[0].charAt(0)).toUpperCase() + ". " + author2[1];

            Terminal.printLine("[1] " + author1Abr + " and " + author2Abr + ", \"" + title + ",\" "
                    + journalTitle + ", " + year + ".");

        } else

            Terminal.printLine("[1] " + author1Abr + " et al." + ", \"" + title + ",\" "
                    + journalTitle + ", " + year + ".");

    }
}
