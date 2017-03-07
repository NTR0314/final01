package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.MyUtil;

public class DirectHIndex extends Command {
    /**
     * Konstruktor des Kommandos "direct h-index"
     */
    DirectHIndex() {
        super(RegexConstant.DIRCET_H_INDEX);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 2);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutString = cutString(input);

        String[] splitCutString = cutString.split(";");

        Terminal.printLine("" + MyUtil.hIndex(MyUtil.stringToIntArray(splitCutString)));

    }
}
