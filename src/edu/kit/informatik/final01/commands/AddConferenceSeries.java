package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.entities.ConferenceSeries;

public class AddConferenceSeries extends Command {
    /**
     * Konstruktor des Kommandos "add conference series"
     */
    AddConferenceSeries() {
        super(RegexConstant.ADD_CONFERENCE_SERIES);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 3);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);

        ConferenceSeries cs = new ConferenceSeries(cutInput);

        if (literatureManager.getConferenceSeriesList().contains(cs)) {
            Terminal.printError("This Conferenceseries is already existing!");
            return;
        }

        literatureManager.getConferenceSeriesList().addConferenceSeries(cs);

        Terminal.printLine("Ok");

    }
}
