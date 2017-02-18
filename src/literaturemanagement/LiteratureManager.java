package literaturemanagement;

import edu.kit.informatik.Terminal;
import literaturemanagement.commands.CommandArray;
import literaturemanagement.lists.*;

public class LiteratureManager {
    private boolean programFlow = true;

    private AuthorList authorList = new AuthorList();
    private JournalList journalList = new JournalList();
    private ConferenceSeriesList conferenceSeriesList = new ConferenceSeriesList();
    private ConferenceList conferenceList = new ConferenceList();
    private ArticleList articleList = new ArticleList();


    public static void main(String[] args) {

        LiteratureManager literatureManager = new LiteratureManager();
        while (literatureManager.programFlow) {
            literatureManager.runCommands(Terminal.readLine());
        }
    }

    public void runCommands(String command) {
            for (int j = 0; j < CommandArray.COMMAND_ARRAY.length; j++) {
                if (command.matches(CommandArray.COMMAND_ARRAY[j].getRegex())) {
                    CommandArray.COMMAND_ARRAY[j].execute(this, command);
                    return;
                }

            }

            Terminal.printError("Command not found!");
        }

    public void setProgramFlow(boolean programFlow) {
        this.programFlow = programFlow;
    }

    public AuthorList getAuthorList() {
        return authorList;
    }

    public JournalList getJournalList() {
        return journalList;
    }

    public ConferenceSeriesList getConferenceSeriesList() {
        return conferenceSeriesList;
    }

    public ConferenceList getConferenceList() {
        return conferenceList;
    }

    public ArticleList getArticleList() {
        return articleList;
    }
}
