package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.entities.Author;
import edu.kit.informatik.final01.lists.ArticleList;
import edu.kit.informatik.final01.lists.AuthorList;

public class CoauthorsOf extends Command {
    /**
     * Konstruktor des Kommandos "coauthors of"
     */
    CoauthorsOf() {
        super(RegexConstant.COAUTHORS_OF);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 2);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutString = cutString(input);

        String[] splitCutString = cutString.split(" ");

        String preName = splitCutString[0];
        String lastName = splitCutString[1];

        Author ourAuthor = new Author(preName, lastName);

        if (!literatureManager.getAuthorList().contains(ourAuthor)) {
            Terminal.printError("Author not found");
            return;
        }

        ArticleList articleByAuthor = literatureManager.getArticleList().getByAuthor(ourAuthor);

        AuthorList coAuthors = new AuthorList();

        for (int i = 0; i < articleByAuthor.getLength(); i++) {
            for (int j = 0; j < articleByAuthor.getAtIndex(i).getAuthorList().getLength(); j++) {
                if (!coAuthors.contains(articleByAuthor.getAtIndex(i).getAuthorList().getAtIndex(j))
                        && !articleByAuthor.getAtIndex(i).getAuthorList().getAtIndex(j).isSame(ourAuthor)) {
                    coAuthors.addAuthor(articleByAuthor.getAtIndex(i).getAuthorList().getAtIndex(j));
                }

            }

        }

        for (int i = 0; i < coAuthors.getLength(); i++) {
            Terminal.printLine(coAuthors.getAtIndex(i).toString());

        }

    }
}
