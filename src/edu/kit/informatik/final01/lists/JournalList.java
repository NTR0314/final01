package edu.kit.informatik.final01.lists;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.entities.Journal;

import java.util.ArrayList;

public class JournalList {

    private final ArrayList<Journal> journalList = new ArrayList<>();

    /**
     * Die Methode fügt der Journal-Liste ein neues Journal hinzu
     * @param journal das neue Journal das hinzugefügt werden soll.
     */
    public void addJournal(Journal journal) {
        journalList.add(journal);
    }

    /**
     * Die Methode gibt ein gesuchtes Journal zurück, das in der Liste vorhanden ist
     * @param nameAsIndex Der Name des gesuchten Journals.
     * @return Das gesuchte Journal, falls vorhanden.
     *         null, falls nicht vorhanden.
     */
    public Journal getJournal(String nameAsIndex) {
        for (Journal aJournalList : this.journalList) {
            if (aJournalList.getName().equals(nameAsIndex)) {
                return aJournalList;
            }

        }
        Terminal.printError("Journal not found");
        return null;
    }

    /**
     * Die Methode prüft ob diese Journal-Liste ein bestimmtes Journal enthält
     * @param journal Das Journal nach dem geschaut werden soll.
     * @return true, falls vorhanden.
     *         false, sonst.
     */
    public boolean contains(Journal journal) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getName().equals(journal.getName())) {
                return true;
            }

        }

        return false;
    }

    /**
     * Die Methode überprüft ob die Journal-List ein bestimmtes Journal enthält.
     * @param name Der Name des gesuchten Journals.
     * @return true, falls vorhanden.
     *         false, sonst.
     */
    public boolean contains(String name) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getName().equals(name)) {
                return true;
            }

        }

        return false;
    }

    /**
     * @return gibt die Länge der Journal-Liste zurück
     */
    public int getLength() {
        return this.journalList.size();
    }

    /**
     * Die Methode gibt ein Journal an einem bestimmten Index zurück
     * @param index der gesuchte Index
     * @return das gesuchte Journal.
     */
    public Journal getAtIndex(int index) {
        return this.journalList.get(index);
    }



}
