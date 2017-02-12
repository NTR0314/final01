package literaturemanagement.system;

import literaturemanagement.venues.Journal;

import java.util.ArrayList;

public class JournalList {

    private ArrayList<Journal> journalList = new ArrayList<>();

    public void addJournal(Journal journal) {
        journalList.add(journal);
    }



}
