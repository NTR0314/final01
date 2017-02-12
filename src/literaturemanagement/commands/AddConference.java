package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.LiteratureManager;
import literaturemanagement.venues.Conference;

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

        literatureManager.getConferenceList().addConference(new Conference(splittedCuttedInput[0],
                Integer.parseInt(splittedCuttedInput[1]), splittedCuttedInput[2]));

        Terminal.printLine("Ok");

    }
}
