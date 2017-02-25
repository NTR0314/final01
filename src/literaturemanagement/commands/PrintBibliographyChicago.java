package literaturemanagement.commands;

import literaturemanagement.LiteratureManager;

public class PrintBibliographyChicago extends Command {
    protected PrintBibliographyChicago() {
        super(RegexConstant.PRINT_BIBLIOGRAPHY_CHICAGO);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 2);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {

    }
}
