package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.LiteratureManager;

public class InProceedings extends Command {
    protected InProceedings() {
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

        int yearToLookFor = Integer.parseInt(splitCutString[1]);

        if (literatureManager.getConferenceSeriesList().getConferenceSeries(splitCutString[0]) == null) {
            Terminal.printError("series " + splitCutString[0] + " not found.");
            return;
        }

//        literatureManager.getConferenceSeriesList().
//                getConferenceSeries(splitCutString[0]).getArticles().printAllInYear(yearToLookFor);

    }
}
