package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.entities.Article;
import edu.kit.informatik.final01.entities.ConferenceSeries;
import edu.kit.informatik.final01.entities.Journal;
import edu.kit.informatik.final01.lists.ArticleList;

import java.util.Collections;

public class PrintBibliographyChicago extends Command {
    /**
     * Konstruktor des Kommandos "print bibliography chicago"
     */
    PrintBibliographyChicago() {
        super(RegexConstant.PRINT_BIBLIOGRAPHY_CHICAGO);
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
                    Terminal.printLine("(" + a.getAuthorList().getAtIndex(0).getLastName() + ", "
                            + a.getYear() + ")" + " " + a.getAuthorList().getAtIndex(0).getChicagoAbr() + ". \""
                            + a.getTitle() + ".\" Paper presented at "
                            + ((ConferenceSeries) a.getVenue()).getName() + ", " + a.getYear() + ", "
                            + ((ConferenceSeries) a.getVenue()).getConference(a.getYear()).getLocation() + ".");
                } else if (a.getAuthorList().getLength() == 2) {
                    Terminal.printLine("(" + a.getAuthorList().getAtIndex(0).getLastName() + ", "
                            + a.getYear() + ")" + " " + a.getAuthorList().getAtIndex(0).getChicagoAbr() + ", and "
                            + a.getAuthorList().getAtIndex(1).getChicagoAbr() + ". \""
                            + a.getTitle() + ".\" Paper presented at "
                            + ((ConferenceSeries) a.getVenue()).getName() + ", " + a.getYear() + ", "
                            + ((ConferenceSeries) a.getVenue()).getConference(a.getYear()).getLocation() + ".");
                } else if (a.getAuthorList().getLength() >= 3) {
                    String beforeAuthors = "(" + a.getAuthorList().getAtIndex(0).getLastName() + ", "
                            + a.getYear() + ")" + " ";
                    String afterAuthors = ". \""
                            + a.getTitle() + ".\" Paper presented at "
                            + ((ConferenceSeries) a.getVenue()).getName() + ", " + a.getYear() + ", "
                            + ((ConferenceSeries) a.getVenue()).getConference(a.getYear()).getLocation() + ".";
                    for (int j = 0; j < a.getAuthorList().getLength() - 1; j++) {
                        beforeAuthors = beforeAuthors + a.getAuthorList().getAtIndex(j).getChicagoAbr() + ", ";
                    }
                    beforeAuthors = beforeAuthors + "and "
                            + a.getAuthorList().getAtIndex(a.getAuthorList().getLength() - 1).getChicagoAbr();

                    Terminal.printLine(beforeAuthors + afterAuthors);
                }
            } else if (a.getVenue() instanceof Journal) {
                if (a.getAuthorList().getLength() == 1) {
                    Terminal.printLine("(" + a.getAuthorList().getAtIndex(0).getLastName() + ", " + a.getYear()
                            + ")" + " " + a.getAuthorList().getAtIndex(0).getChicagoAbr() + ". \"" + a.getTitle()
                            + ".\" " + ((Journal) a.getVenue()).getName() + " (" + a.getYear() + ").");
                } else if (a.getAuthorList().getLength() == 2) {
                    Terminal.printLine("(" + a.getAuthorList().getAtIndex(0).getLastName() + ", " + a.getYear()
                            + ")" + " " + a.getAuthorList().getAtIndex(0).getChicagoAbr() + ", and "
                            + a.getAuthorList().getAtIndex(1).getChicagoAbr() + ". \"" + a.getTitle()
                            + ".\" " + ((Journal) a.getVenue()).getName() + " (" + a.getYear() + ").");
                } else if (a.getAuthorList().getLength() >= 3) {
                    String beforeAuthors = "(" + a.getAuthorList().getAtIndex(0).getLastName() + ", " + a.getYear()
                            + ")" + " ";

                    String afterAuthors = ". \"" + a.getTitle()
                            + ".\" " + ((Journal) a.getVenue()).getName() + " (" + a.getYear() + ").";

                    for (int j = 0; j < a.getAuthorList().getLength() - 1; j++) {
                        beforeAuthors = beforeAuthors + a.getAuthorList().getAtIndex(j).getChicagoAbr() + ", ";
                    }

                    beforeAuthors = beforeAuthors + "and "
                            + a.getAuthorList().getAtIndex(a.getAuthorList().getLength() - 1).getChicagoAbr();

                    Terminal.printLine(beforeAuthors + afterAuthors);
                }
            }
        }
    }
}

