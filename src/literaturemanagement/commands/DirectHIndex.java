package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.LiteratureManager;
import literaturemanagement.MyUtil;

public class DirectHIndex extends Command {
    protected DirectHIndex() {
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

        Terminal.printLine(MyUtil.hIndex(MyUtil.stringToIntArray(splitCutString)));

    }
}
