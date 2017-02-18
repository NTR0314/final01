package literaturemanagement.lists;

import edu.kit.informatik.Terminal;
import jdk.nashorn.internal.scripts.JO;
import literaturemanagement.entities.Journal;

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

    public boolean contains(Journal journal) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getName().equals(journal.getName())) {
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
