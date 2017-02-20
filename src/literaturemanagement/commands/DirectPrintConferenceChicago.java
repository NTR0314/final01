package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.LiteratureManager;

public class DirectPrintConferenceChicago extends Command {
    protected DirectPrintConferenceChicago() {
        super(RegexConstant.DIRECT_PRINT_CONFERENCE_CHICAGO);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 3);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {

        String cutString = cutString(input);

        String[] splitCutString = cutString.split(":|,");

        String author1[] = splitCutString[1].split(" ");
        String author1Abr = author1[1] + ", " + author1[0];

        String title = splitCutString[4];
        String seriesName = splitCutString[5];
        String location = splitCutString[6];
        String year = splitCutString[7];

        if (splitCutString[2].isEmpty() && splitCutString[3].isEmpty()) {

            Terminal.printLine("(" + author1[1] + ", " + year + ")" + " " + author1Abr + ". \"" + title + ".\" Paper presented at "
                    + seriesName + ", " + year + ", " + location + ".");
            return;

        }

        String author2[] = splitCutString[2].split(" ");
        String author2Abr =  author2[1] + ", " + author2[0];

        if (splitCutString[3].isEmpty()) {

            Terminal.printLine("(" + author1[1] + ", " + year + ")" + " " + author1Abr + ", and " + author2Abr + ". \"" + title + ".\" Paper presented at "
                    + seriesName + ", " + year + ", " + location + ".");
            return;

        }

        String author3[] = splitCutString[3].split(" ");
        String author3Abr =  author3[1] + ", " + author3[0];

        Terminal.printLine("(" + author1[1] + ", " + year + ")" + " " + author1Abr + ", " + author2Abr + ", " + author3Abr + ". \"" + title + ".\" Paper presented at " + seriesName + ", " + year + ", " + location + ".");

    }

}
