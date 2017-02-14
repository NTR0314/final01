package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.LiteratureManager;

public class AllPublications extends Command{
    protected AllPublications() {
        super(RegexConstant.ALL_PUBLICATIONS);
    }

    @Override
    public String cutString(String input) {
        return input;
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        for (int i = 0; i < literatureManager.getArticleList().getLength(); i++) {
                Terminal.printLine(literatureManager.getArticleList().getAtIndex(i).getIdentifier());
        }

    }
}
