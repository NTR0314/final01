package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.entities.Article;
import edu.kit.informatik.final01.entities.ConferenceSeries;
import edu.kit.informatik.final01.entities.Journal;
import edu.kit.informatik.final01.lists.ArticleList;

import java.util.Collections;

public class PrintBibliographyIEEE extends Command {
    /**
     * Konstruktor des Kommandos "print bibliography ieee"
     */
    PrintBibliographyIEEE() {
        super(RegexConstant.PRINT_BIBLIOPGRAPHY_IEEE);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 2);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutString = cutString(input);

        String[] splitCutString = cutString.split("[;:]");

        for (int i = 1; i < splitCutString.length; i++) {
            if (!literatureManager.getArticleList().contains(splitCutString[i])
                    || !literatureManager.getArticleList().getArticle(splitCutString[i]).isValid()) {
                Terminal.printError("One of the Articles is either invalid or does not exist!");
                return;
            }
        }

        ArticleList sortedListOfArticlesToOutPrint = new ArticleList();

        for (int i = 1; i < splitCutString.length; i++) {
            Article article = literatureManager.getArticleList().getArticle(splitCutString[i]);
            if (!sortedListOfArticlesToOutPrint.contains(article)) {
                sortedListOfArticlesToOutPrint.add(article);
            }
        }

        Collections.sort(sortedListOfArticlesToOutPrint.getArticleList());

        for (int i = 0; i < sortedListOfArticlesToOutPrint.getLength(); i++) {
            Article a = sortedListOfArticlesToOutPrint.getAtIndex(i);

            if (a.getVenue() instanceof ConferenceSeries) {
                if (a.getAuthorList().getLength() == 1) {
                    Terminal.printLine("[" + (i + 1) + "] " + a.getAuthorList().getAtIndex(0).getIEEEAbr()
                            + ", \"" + a.getTitle() + ",\" in Proceedings of "
                            + ((ConferenceSeries) a.getVenue()).getName() + ", "
                            + ((ConferenceSeries) a.getVenue()).getConference(a.getYear()).getLocation()
                            + ", " + a.getYear() + ".");
                } else if (a.getAuthorList().getLength() == 2) {
                    Terminal.printLine("[" + (i + 1) + "] " + a.getAuthorList().getAtIndex(0).getIEEEAbr() + " and "
                            + a.getAuthorList().getAtIndex(1).getIEEEAbr()
                            + ", \"" + a.getTitle() + ",\" in Proceedings of "
                            + ((ConferenceSeries) a.getVenue()).getName() + ", "
                            + ((ConferenceSeries) a.getVenue()).getConference(a.getYear()).getLocation()
                            + ", " + a.getYear() + ".");
                } else if (a.getAuthorList().getLength() >= 3) {
                    Terminal.printLine("[" + (i + 1) + "] " + a.getAuthorList().getAtIndex(0).getIEEEAbr() + " et al."
                            + ", \"" + a.getTitle() + ",\" in Proceedings of "
                            + ((ConferenceSeries) a.getVenue()).getName() + ", "
                            + ((ConferenceSeries) a.getVenue()).getConference(a.getYear()).getLocation()
                            + ", " + a.getYear() + ".");
                }
            } else if (a.getVenue() instanceof Journal) {
                if (a.getAuthorList().getLength() == 1) {
                    Terminal.printLine("[" + (i + 1) + "] " + a.getAuthorList().getAtIndex(0).getIEEEAbr()
                            + ", \"" + a.getTitle() + ",\" "
                            + ((Journal) a.getVenue()).getName() + ", " + a.getYear() + ".");
                } else if (a.getAuthorList().getLength() == 2) {
                    Terminal.printLine("[" + (i + 1) + "] " + a.getAuthorList().getAtIndex(0).getIEEEAbr() + " and "
                            + a.getAuthorList().getAtIndex(1).getIEEEAbr()
                            + ", \"" + a.getTitle() + ",\" "
                            + ((Journal) a.getVenue()).getName() + ", " + a.getYear() + ".");
                } else if (a.getAuthorList().getLength() >= 3) {
                    Terminal.printLine("[" + (i + 1) + "] " + a.getAuthorList().getAtIndex(0).getIEEEAbr() + " et al."
                            + ", \"" + a.getTitle() + ",\" "
                            + ((Journal) a.getVenue()).getName() + ", " + a.getYear() + ".");
                }
            }
        }
    }
}
