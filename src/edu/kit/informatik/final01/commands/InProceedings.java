package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.entities.ConferenceSeries;
import edu.kit.informatik.final01.lists.ConferenceList;

public class InProceedings extends Command {
    /**
     * Konstruktor des Kommandos "in proceedings"
     */
    InProceedings() {
        super(RegexConstant.IN_PROCEEDINGS);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 2);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutString = cutString(input);

        String[] splitCutString = cutString.split(",");

        String seriesName = splitCutString[0];
        int yearToLookFor = Integer.parseInt(splitCutString[1]);

        if (!literatureManager.getConferenceSeriesList().contains(seriesName)) {
            Terminal.printError("series " + seriesName + " not found.");
            return;
        }

        ConferenceSeries cs = literatureManager.getConferenceSeriesList().getConferenceSeries(seriesName);

        if (!cs.getConferences().containsAtYear(seriesName, yearToLookFor)) {
            Terminal.printError("This conferenceseries has no conference in " + splitCutString[1]);
            return;
        }

        ConferenceList c = cs.getConferences();

        for (int i = 0; i < c.getLength(); i++) {
            for (int j = 0; j < c.getAtIndex(i).getAtYear(yearToLookFor).getLength(); j++) {
                Terminal.printLine(c.getAtIndex(i).getAtYear(yearToLookFor).getAtIndex(j).getIdentifier());

            }
        }

    }
}
