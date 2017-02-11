package literaturemanagement.commands;

import literaturemanagement.LiteratureManager;

import java.util.regex.Pattern;

public abstract class Command {

    private final Pattern p;

    private final String regex;

    protected Command(String regex) {
        p = Pattern.compile(regex);
        this.regex = regex;
    }

    public Pattern getP() {
        return p;
    }

    public String getRegex() {
        return regex;
    }

    abstract public String cutString(String input);

    abstract public void execute(LiteratureManager literatureManager, String input);

    public String cutStringHelper(String input, int amountOfCommandWords) {
        String[] tempStringArray = input.split(" ", amountOfCommandWords + 1);

        return tempStringArray[amountOfCommandWords];
    }

    public boolean matches(String input) {
        return p.matcher(input).matches();
    }
}
