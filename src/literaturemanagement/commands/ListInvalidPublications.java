package literaturemanagement.commands;

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


    }
}
