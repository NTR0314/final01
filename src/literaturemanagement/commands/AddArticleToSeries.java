package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.entities.Article;
import literaturemanagement.LiteratureManager;

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

        String[] splittedCutInput = cutInput.split(",|:", 4);

        String seriesName = splittedCutInput[0];
        String articleName = splittedCutInput[1];
        int year = Integer.parseInt(splittedCutInput[2]);
        String articleTitle = splittedCutInput[3];

        Article articleToAdd = new Article(articleName, articleTitle, year);

        if (literatureManager.getConferenceSeriesList().getConferenceSeries(seriesName) == null) {
            Terminal.printError("ConferenceSeries not found!");
            return;
        }

        if (!literatureManager.getConferenceList().contains(seriesName, year)) {
            Terminal.printError("Conference in that year not Existing");
            return;
        }

        if (literatureManager.getConferenceList().getWithSeriesName(seriesName).contains(articleName)) {
            Terminal.printError("This Conference already contains " + seriesName + "!");
            return;
        } else {
            literatureManager.getConferenceSeriesList().getConferenceSeries(splittedCutInput[0])
                    .add(literatureManager.getConferenceList().getWithSeriesName(seriesName));
            literatureManager.getConferenceList().getWithSeriesName(seriesName).add(articleToAdd);
        }

        Terminal.printLine("Ok");
    }
}
