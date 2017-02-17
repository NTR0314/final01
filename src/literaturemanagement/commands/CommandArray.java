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
            new AddKeywordsTo(),
            new AllPublications(),
            new ListInvalidPublications(),
            new PublicationsBy(),
            new InProceedings(),
            new FindKeywords(),
            new Jaccard(),
            new Similarity(),
            new DirectH_index(),
            new H_index(),
            new CoauthorsOf(),
            new ForeignCitationsOf()

    };
}

