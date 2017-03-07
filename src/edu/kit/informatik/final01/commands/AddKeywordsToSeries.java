package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.entities.ConferenceSeries;

public class AddKeywordsToSeries extends Command {
    /**
     * Konstruktor des Kommandos "add keywords to series"
     */
    AddKeywordsToSeries() {
        super(RegexConstant.ADD_KEYWORDS_TO_SERIES);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 4);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutString = cutString(input);

        String[] splitCutString = cutString.split("[:;]");

        String seriesName = splitCutString[0];

        if (!literatureManager.getConferenceSeriesList().contains(seriesName)) {
            Terminal.printError("ConferenceSeries " + seriesName + " not found!");
            return;
        }

        ConferenceSeries cs = literatureManager.getConferenceSeriesList().getConferenceSeries(seriesName);

        for (int i = 1; i < splitCutString.length; i++) {
            cs.addKeyword(splitCutString[i]);
        }

        Terminal.printLine("Ok");

    }
}
