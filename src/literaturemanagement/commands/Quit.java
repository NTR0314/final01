package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.LiteratureManager;

public class Quit extends Command {

    protected Quit() {
        super(RegexConstant.QUIT);
    }

    @Override
    public String cutString(String input) {
        return input;
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        literatureManager.setProgramFlow(false);

        Terminal.printLine("Ok");

    }
}
