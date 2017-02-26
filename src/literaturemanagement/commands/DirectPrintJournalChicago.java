package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.LiteratureManager;

public class DirectPrintJournalChicago extends Command {
    protected DirectPrintJournalChicago() {
        super(RegexConstant.DIRECT_PRINT_JOURNAL_CHICAGO);
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
        String author1Abr = author1[1] + ", " + author1[0];

        String title = splitCutString[4];
        String journalTitle = splitCutString[5];
        String year = splitCutString[6];

        if (splitCutString[2].isEmpty() && splitCutString[3].isEmpty()) {

            Terminal.printLine("(" + author1[1] + ", " + year + ")" + " " + author1Abr + ". \"" + title + ".\" "
                    + journalTitle + " (" + year  + ").");
            return;

        }

        String author2[] = splitCutString[2].split(" ");
        String author2Abr =  author2[1] + ", " + author2[0];

        if (splitCutString[3].isEmpty()) {

            Terminal.printLine("(" + author1[1] + ", " + year + ")" + " " + author1Abr + ", and " + author2Abr + ". \"" + title + ".\" "
                    + journalTitle + " (" + year  + ").");
            return;

        }

        String author3[] = splitCutString[3].split(" ");
        String author3Abr =  author3[1] + ", " + author3[0];

        Terminal.printLine("(" + author1[1] + ", " + year + ")" + " " + author1Abr
                + ", " + author2Abr + ", " + author3Abr + ". \" " + title + ".\""
                + journalTitle + " (" + year  + ").");
    }
}
