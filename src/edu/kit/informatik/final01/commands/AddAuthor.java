package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.entities.Author;

public class AddAuthor extends Command {
    /**
     * Konstruktor des Kommandos "add author"
     */
    AddAuthor() {
        super(RegexConstant.ADD_AUTHOUR);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 2);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);
        String[] splitInput = cutInput.split(",");

        Author author2Add = new Author(splitInput[0], splitInput[1]);

        if (literatureManager.getAuthorList().contains(author2Add)) {
            Terminal.printError("Author already existing!");
            return;
        }

        literatureManager.getAuthorList().addAuthor(author2Add);

        Terminal.printLine("Ok");


    }
}
