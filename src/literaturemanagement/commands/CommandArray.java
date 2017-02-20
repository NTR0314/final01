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
            new AddArticleToSeries(),
            new WrittenBy(),
            new Cites(),
            new AddKeywordsToPub(),
            new AddKeywordsToConference(),
            new AddKeywordsToSeries(),
            new AddKeywordsToJournal(),
            new AllPublications(),
            new ListInvalidPublications(),
            new PublicationsBy(),
            new InProceedings(),
            new FindKeywords(),
            new Jaccard(),
            new Similarity(),
            new DirectH_index(),
            new HIndex(),
            new CoauthorsOf(),
            new ForeignCitationsOf(),
            new AddArticleToJournal(),
            new DirectPrintConferenceIEEE()

    };
}

