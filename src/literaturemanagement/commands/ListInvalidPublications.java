package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.LiteratureManager;

public class ListInvalidPublications extends Command {
    protected ListInvalidPublications() {
        super(RegexConstant.LIST_INVALID_PUBLICATIONS);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 0);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        for (int i = 0; i < literatureManager.getArticleList().getLength(); i++) {
            if (!literatureManager.getArticleList().getAtIndex(i).isValid()) {
                Terminal.printLine(literatureManager.getArticleList().getAtIndex(i).getIdentifier());
            }
        }


    }
}
