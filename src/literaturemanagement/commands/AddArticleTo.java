package literaturemanagement.commands;

import literaturemanagement.LiteratureManager;

public class AddArticleTo extends Command {
    protected AddArticleTo() {
        super(RegexConstant.ADD_ARTICLE_TOO);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 3);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);

        String[] splittedCutInput = cutInput.split(",|:");

    }
}
