package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.MyUtil;

public class DirectPrintConferenceIEEE extends Command {
    /**
     * Konstruktor des Kommandos "direct print conference ieee"
     */
    DirectPrintConferenceIEEE() {
        super(RegexConstant.DIRECT_PRINT_CONFERENCE_IEEE);
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
        String seriesName = splitCutString[5];
        String location = splitCutString[6];
        String year = splitCutString[7];

        if (!MyUtil.isValidYear(year)) {
            Terminal.printError("Invalid Year!");
            return;
        }

        if (splitCutString[2].isEmpty() && splitCutString[3].isEmpty()) {

            Terminal.printLine("[1] " + author1Abr + ", \"" + title + ",\" in Proceedings of "
                    + seriesName + ", " + location + ", " + year + ".");

        } else if (splitCutString[3].isEmpty()) {

            String author2[] = splitCutString[2].split(" ");
            String author2Abr = String.valueOf(author2[0].charAt(0)).toUpperCase() + ". " + author2[1];

            Terminal.printLine("[1] " + author1Abr + " and " + author2Abr + ", \"" + title
                    + ",\" in Proceedings of " + seriesName + ", " + location + ", " + year + ".");

        } else
            Terminal.printLine("[1] " + author1Abr + " et al." + ", \"" + title + ",\" in Proceedings of "
                    + seriesName + ", " + location + ", " + year + ".");

    }
}
