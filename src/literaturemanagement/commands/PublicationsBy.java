package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.entities.Author;
import literaturemanagement.LiteratureManager;
import literaturemanagement.lists.AuthorList;

public class PublicationsBy extends Command {
    protected PublicationsBy() {
        super(RegexConstant.PUBLICATIONS_BY);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 2);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutString = cutString(input);
        String[] splitCutString = cutString.split(" |;");

        for (int i = 0; i < splitCutString.length; i += 2) {
            Author author = new Author(splitCutString[i], splitCutString[i + 1]);
            if (!literatureManager.getAuthorList().contains(author)) {
                Terminal.printError("One of the given Authors was not found!");
                return;
            }

        }

        AuthorList authorList = new AuthorList();

        for (int i = 0; i < splitCutString.length; i += 2) {
            Author author = new Author(splitCutString[i], splitCutString[i + 1]);

            authorList.addAuthor(author);

        }

        for (int i = 0; i < literatureManager.getArticleList().getArticlesFrom(authorList).size(); i++) {
            Terminal.printLine(literatureManager.getArticleList().getArticlesFrom(authorList).get(i));

        }


    }
}
