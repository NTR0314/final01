package literaturemanagement.system;

import edu.kit.informatik.Terminal;
import literaturemanagement.venues.Journal;

import java.util.ArrayList;

public class JournalList {

    private ArrayList<Journal> journalList = new ArrayList<>();

    public void addJournal(Journal journal) {
        journalList.add(journal);
    }

    public Journal getJournal(String nameAsIndex) {
        for (int i = 0; i < this.journalList.size(); i++) {
            if (this.journalList.get(i).getName().equals(nameAsIndex)) {
                return this.journalList.get(i);
            }

        }
        Terminal.printError("Journal not found");
        return null;
    }



}
