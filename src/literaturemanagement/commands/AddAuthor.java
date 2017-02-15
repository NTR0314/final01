package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.entities.Author;
import literaturemanagement.LiteratureManager;

public class AddAuthor extends Command {

    protected AddAuthor() {
        super(RegexConstant.ADD_AUTHOUR);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 2);
    }


    //TODO Exception "Error, author with same name already added."

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);
        String[] splitInput = cutInput.split(",");

        literatureManager.getAuthorList().addAuthor(new Author(splitInput[0], splitInput[1]));

        Terminal.printLine("Ok");


    }
}
