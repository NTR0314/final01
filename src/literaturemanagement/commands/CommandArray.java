package literaturemanagement.commands;

public class CommandArray {
    private CommandArray() {
    }

    public static final Command[] COMMAND_ARRAY = {
            new Quit(),
            new AddAuthor()

    };
}

