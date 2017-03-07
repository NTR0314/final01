package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.MyUtil;
import edu.kit.informatik.final01.entities.Author;

public class DirectPrintConferenceChicago extends Command {
    /**
     * Konstruktor des Kommandos "direct print conference chicago"
     */
    DirectPrintConferenceChicago() {
        super(RegexConstant.DIRECT_PRINT_CONFERENCE_CHICAGO);
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
        Author a1 = new Author(author1[0], author1[1]);

        String title = splitCutString[4];
        String seriesName = splitCutString[5];
        String location = splitCutString[6];
        String year = splitCutString[7];

        if (splitCutString[1].isEmpty()) {
            Terminal.printLine("You have to give an author or put it in the first slot");
            return;
        }

        if (!MyUtil.isValidYear(year)) {
            Terminal.printLine("Year not valid!");
            return;
        }

        if (splitCutString[2].isEmpty() && splitCutString[3].isEmpty()) {

            Terminal.printLine("(" + author1[1] + ", " + year + ")"
                    + " " + a1.getChicagoAbr() + ". \"" + title + ".\" Paper presented at "
                    + seriesName + ", " + year + ", " + location + ".");
            return;

        }

        String author2[] = splitCutString[2].split(" ");
        Author a2 = new Author(author2[0], author2[1]);

        if (splitCutString[3].isEmpty()) {

            Terminal.printLine("(" + author1[1] + ", " + year + ")" + " " + a1.getChicagoAbr() + ", and "
                    + a2.getChicagoAbr() + ". \"" + title + ".\" Paper presented at "
                    + seriesName + ", " + year + ", " + location + ".");
            return;

        }

        String[] author3 = splitCutString[3].split(" ");
        Author a3 = new Author(author3[0], author3[1]);
        Terminal.printLine("(" + author1[1] + ", " + year + ")" + " " + a1.getChicagoAbr() + ", "
                + a2.getChicagoAbr() + ", and " + a3.getChicagoAbr() + ". \"" + title + ".\" Paper presented at "
                + seriesName + ", " + year + ", " + location + ".");

    }

}
