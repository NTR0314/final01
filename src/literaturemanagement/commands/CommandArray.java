package literaturemanagement.commands;

public class CommandArray {
    private CommandArray() {
    }

    public static final Command[] COMMAND_ARRAY = {
            new Quit(),
            new AddAuthor(),
            new AddJournal(),
            new AddConferenceSeries(),
            new AddConference(),
            new AddArticleTo(),
            new WrittenBy(),
            new Cites(),
            new AddKeywordsTo()

    };
}

