package edu.kit.informatik.final01.commands;

public final class CommandArray {
    /**
     * ein Array aus Kommandos, das alle Kommands enthält. Wird benutzt um Kommandos zu erkennen(Hierbei
     * wird durch das Array iteriert und geschaut ob das jeweilige Regex mit der Eingabe übereinstimmmt.
     */
    public static final Command[] COMMANDS = {
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
            new DirectHIndex(),
            new HIndex(),
            new CoauthorsOf(),
            new ForeignCitationsOf(),
            new AddArticleToJournal(),
            new DirectPrintConferenceIEEE(),
            new DirectPrintConferenceChicago(),
            new DirectPrintJournalIEEE(),
            new DirectPrintJournalChicago(),
            new PrintBibliographyChicago(),
            new PrintBibliographyIEEE()

    };

    private CommandArray() {
    }
    /**
     * @return gibt das Array mit allen Kommandos zurück
     */
    public Command[] getCommands() {
        return COMMANDS;
    }

}

