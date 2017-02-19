package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.entities.Article;
import literaturemanagement.LiteratureManager;
import literaturemanagement.entities.Conference;
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

        String[] splittedCutInput = cutInput.split(",|:", 4);

        String seriesName = splittedCutInput[0];
        String articleName = splittedCutInput[1];
        int year = Integer.parseInt(splittedCutInput[2]);
        String articleTitle = splittedCutInput[3];

        Article articleToAdd = new Article(articleName, articleTitle, year);

        if (!literatureManager.getConferenceList().contains(seriesName)) {
            Terminal.printError("No Conference with that seriesName found!");
            return;
        }

        Conference c = literatureManager.getConferenceList().getWithSeriesName(seriesName);

        if (!literatureManager.getConferenceList().containsAtYear(seriesName, year)) {
            Terminal.printError("Conference in that year not Existing");
            return;
        }

        if (c.contains(articleName)) {
            Terminal.printError("This Conference already contains " + articleName + "!");
            return;
        } else {
            c.add(articleToAdd);
            literatureManager.getArticleList().add(articleToAdd);
        }

        Terminal.printLine("Ok");
    }
}
