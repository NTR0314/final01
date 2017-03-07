package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;

public class Quit extends Command {
    /**
     * Konstruktor des Kommandos "quit"
     */
    Quit() {
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
