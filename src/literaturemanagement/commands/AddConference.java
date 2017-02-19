package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.LiteratureManager;
import literaturemanagement.entities.Conference;

public class AddConference extends Command{
    protected AddConference() {
        super(RegexConstant.ADD_CONFERENCE);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 2);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);
        String[] splittedCuttedInput = cutInput.split(",");

        if (Integer.parseInt(splittedCuttedInput[1]) < 1000) {
            Terminal.printError("Year is to low!");
            return;
        }

        Conference conferenceToAdd = (new Conference(splittedCuttedInput[0],
                Integer.parseInt(splittedCuttedInput[1]), splittedCuttedInput[2]));

        if (literatureManager.getConferenceList().containsAtYear(conferenceToAdd)) {
            Terminal.printError("Conference already existing!");
            return;
        }

        if (!literatureManager.getConferenceSeriesList().contains(conferenceToAdd.getSeriesName())) {
            Terminal.printError("Conferenceseries is not existing!");
            return;
        }

        literatureManager.getConferenceList().addConference(conferenceToAdd);

        Terminal.printLine("Ok");

    }
}
