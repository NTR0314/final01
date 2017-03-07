package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.MyUtil;
import edu.kit.informatik.final01.entities.Author;
import edu.kit.informatik.final01.lists.ArticleList;

public class HIndex extends Command {
    /**
     * Konstruktor des Kommandos "h-index"
     */
    HIndex() {
        super(RegexConstant.H_INDEX);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 1);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);

        String[] cutSplitInput = cutInput.split(" ");

        String firstName = cutSplitInput[0];
        String lastName = cutSplitInput[1];

        Author ourAuthor = new Author(firstName, lastName);
        if (!literatureManager.getAuthorList().contains(ourAuthor)) {
            Terminal.printError("Author not found");
            return;
        }

        ArticleList articlesByOurAuthor = literatureManager.getArticleList().getByAuthor(ourAuthor);

        ArticleList allArticles = literatureManager.getArticleList();

        int[] citationCount = new int[articlesByOurAuthor.getLength()];

        for (int i = 0; i < articlesByOurAuthor.getLength(); i++) {
            for (int j = 0; j < allArticles.getLength(); j++) {
                if (allArticles.getAtIndex(j).getReferences().contains(articlesByOurAuthor.getAtIndex(i))) {
                    citationCount[i]++;
                }

            }


        }

        Terminal.printLine("" + MyUtil.hIndex(citationCount));



    }
}
