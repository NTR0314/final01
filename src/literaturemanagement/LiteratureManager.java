package literaturemanagement;

import edu.kit.informatik.Terminal;
import literaturemanagement.commands.CommandArray;
import literaturemanagement.system.AuthorList;
import literaturemanagement.system.ConferenceSeriesList;
import literaturemanagement.system.JournalList;

public class LiteratureManager {
    private boolean programmFlow = true;

    private AuthorList authorList = new AuthorList();
    private JournalList journalList = new JournalList();
    private ConferenceSeriesList conferenceSeriesList = new ConferenceSeriesList();


    public static void main(String[] args) {

        LiteratureManager literatureManager = new LiteratureManager();
        while (literatureManager.programmFlow) {
            literatureManager.runCommands(Terminal.readFile("C:\\Users\\Bosswald\\Desktop\\hehexd.txt"));
        }
    }

    public void runCommands(String[] commands) {
        for (int i = 0; i < commands.length; i++) {
            for (int j = 0; j < CommandArray.COMMAND_ARRAY.length; j++) {
                if (commands[i].matches(CommandArray.COMMAND_ARRAY[j].getRegex())) {
                    CommandArray.COMMAND_ARRAY[j].execute(this, commands[i]);
                }

            }
        }


    }

    public void setProgrammFlow(boolean programmFlow) {
        this.programmFlow = programmFlow;
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
}
