package literaturemanagement.lists;

import edu.kit.informatik.Terminal;
import literaturemanagement.entities.Journal;

import java.util.ArrayList;

public class JournalList {

    private final ArrayList<Journal> journalList = new ArrayList<>();

    public void addJournal(Journal journal) {
        journalList.add(journal);
    }

    public Journal getJournal(String nameAsIndex) {
        for (Journal aJournalList : this.journalList) {
            if (aJournalList.getName().equals(nameAsIndex)) {
                return aJournalList;
            }

        }
        Terminal.printError("Journal not found");
        return null;
    }

    public boolean contains(Journal journal) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getName().equals(journal.getName())) {
                return true;
            }

        }

        return false;
    }

    public boolean contains(String name) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getName().equals(name)) {
                return true;
            }

        }

        return false;
    }

    public int getLength() {
        return this.journalList.size();
    }

    public Journal getAtIndex(int index) {
        return this.journalList.get(index);
    }



}
