package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.LiteratureManager;
import literaturemanagement.entities.Conference;

public class AddKeywordsToConference extends Command {
    protected AddKeywordsToConference() {
        super(RegexConstant.ADD_KEYWORDS_TO_CONFERENCE);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 4);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutString = cutString(input);

        String[] splitCutString = cutString.split(",|:|;");

        String seriesName = splitCutString[0];
        int year = Integer.parseInt(splitCutString[1]);

        if (!literatureManager.getConferenceList().containsAtYear(seriesName, year)) {
            Terminal.printError("Conference " + seriesName + " at year:" + splitCutString[1] + " not found!");
            return;
        }

        Conference c = literatureManager.getConferenceList().getConference(seriesName, year);

        for (int i = 2; i < splitCutString.length; i++) {
            c.addKeyword(splitCutString[i]);
        }

        Terminal.printLine("Ok");

    }
}
