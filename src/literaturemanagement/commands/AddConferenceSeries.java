package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.ConferenceSeries;
import literaturemanagement.LiteratureManager;

public class AddConferenceSeries extends Command{
    protected AddConferenceSeries() {
        super(RegexConstant.ADD_CONFERENCE_SERIES);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 3);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);
        literatureManager.getConferenceSeriesList().addConferenceSeries(new ConferenceSeries(cutInput));

        Terminal.printLine("Ok");

    }
}
