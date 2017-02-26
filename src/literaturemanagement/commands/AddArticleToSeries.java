package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.entities.Article;
import literaturemanagement.LiteratureManager;
import literaturemanagement.entities.ConferenceSeries;

public class AddArticleToSeries extends Command {
    protected AddArticleToSeries() {
        super(RegexConstant.ADD_ARTICLE_TOO_SERIES);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 4);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);

        String[] splittedCutInput = cutInput.split("[,:]", 4);

        String seriesName = splittedCutInput[0];
        String articleName = splittedCutInput[1];
        int year = Integer.parseInt(splittedCutInput[2]);
        String articleTitle = splittedCutInput[3];

        if (!literatureManager.getConferenceSeriesList().contains(seriesName)) {
            Terminal.printError("No Conference with that seriesName found!");
            return;
        }

        ConferenceSeries cs = literatureManager.getConferenceSeriesList().getConferenceSeries(seriesName);

        Article articleToAdd = new Article(articleName, articleTitle, year, cs);

        if (!literatureManager.getConferenceList().containsAtYear(seriesName, year)) {
            Terminal.printError("Conference in that year not Existing");
            return;
        }

        if (cs.contains(articleName)) {
            Terminal.printError("This Conferenceseries already contains " + articleName + "!");
            return;
        } else {
            cs.getConference(year).add(articleToAdd);
            literatureManager.getArticleList().add(articleToAdd);
        }

        Terminal.printLine("Ok");
    }
}
