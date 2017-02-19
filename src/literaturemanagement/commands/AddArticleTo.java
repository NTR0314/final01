package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.entities.Article;
import literaturemanagement.LiteratureManager;
import literaturemanagement.entities.Conference;
import literaturemanagement.entities.ConferenceSeries;

public class AddArticleTo extends Command {
    protected AddArticleTo() {
        super(RegexConstant.ADD_ARTICLE_TOO);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 4);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);

        String[] splittedCutInput = cutInput.split(",|:", 4);

        Article articleToAdd = new Article(splittedCutInput[1], splittedCutInput[3],
                Integer.parseInt(splittedCutInput[2]));

        if (!literatureManager.getConferenceList().contains(splittedCutInput[0],
                Integer.parseInt(splittedCutInput[2])) &&
                splittedCutInput[0].equals("series")) {
            Terminal.printError("Conference not found");
            return;
        }

        if (!literatureManager.getJournalList().contains(splittedCutInput[0])
                && splittedCutInput[0].equals("journal")) {
            Terminal.printError("Journal not found");
            return;
        }

        if (splittedCutInput[0].equals("journal") &&
                literatureManager.getJournalList().getJournal(splittedCutInput[0]) != null) {
            literatureManager.getJournalList().getJournal(splittedCutInput[0]).getArticles().add(articleToAdd);

        }

        else if(literatureManager.getConferenceSeriesList().getConferenceSeries(splittedCutInput[0]) != null) {
            literatureManager.getConferenceSeriesList().getConferenceSeries(splittedCutInput[0])
                    .getArticleArrayList().add(articleToAdd);
        }

        Terminal.printLine("Ok");
    }
}
