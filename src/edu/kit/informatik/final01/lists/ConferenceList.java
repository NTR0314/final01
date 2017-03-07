package edu.kit.informatik.final01.lists;

import edu.kit.informatik.final01.entities.Conference;

import java.util.ArrayList;

public class ConferenceList {

    private final ArrayList<Conference> conferenceList = new ArrayList<>();

    /**
     * Die Methode fügt eine Konferenz zu dieser KonferenzListe hinzu
     * @param conference Die Konferenz die hinzugefügt werden soll
     */
    public void addConference(Conference conference) {
        this.conferenceList.add(conference);
    }

    /**
     * Die Methode checkt ob eine Konferenz an einem bestimmen Jahr schon vorhanden ist
     * @param conference Die Konferenz an dessen jahr geschaut werden soll
     * @return true, falls die Konferenz vorhanden ist.
     *         false, sonst
     */
    public boolean containsAtYear(Conference conference) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getSeriesName().equals(conference.getSeriesName())
                    && this.getAtIndex(i).getYear() == conference.getYear()) {
                return true;
            }

        }

        return false;

    }

    /**
     * Die Methode checkt ob eine Konferenz zu einem bestimmten Jahr in dieser KonferenzListe vorhanden ist
     * @param name Der Name der KonferenzSerie
     * @param year Das Jahr der Konferenz
     * @return true, falls vorhanden.
     *         false, sonst.
     */
    public boolean containsAtYear(String name, int year) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getSeriesName().equals(name)
                    && this.getAtIndex(i).getYear() == year) {
                return true;
            }

        }

        return false;

    }

    /**
     * Die Methode checkt ob einee Konferenz mit gegebenem Namen in dieser Liste vorhanden ist
     * @param name der gesuchte Name
     * @return true, falls vorhanden.
     *         false, sonst.
     */
    public boolean contains(String name) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getSeriesName().equals(name)) {
                return true;
            }

        }

        return false;

    }

    /**
     * Die Methode gibt die Länge der Liste zurück
     * @return die Länge der Liste
     */
    public int getLength() {
        return this.conferenceList.size();
    }

    /**
     * Die Methode gibt eine Konferenz welche bei gegebenem Index in der Liste gespeicht wurde zurück
     * @param index Der gesuchte Index.
     * @return Die gesuchte Konferenz.
     */
    public Conference getAtIndex(int index) {
        return this.conferenceList.get(index);
    }

    /**
     * Die Methode gibt eine gesuchte Konferenz zurück
     * @param seriesName der Name der KonferenzSerie der gesuchten Konferenz
     * @param year das Jahr der Konferenz
     * @return die Konferenz die gesucht wird, falls vorhanden,
     *         null sonst
     */
    public Conference getConference(String seriesName, int year) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.conferenceList.get(i).getSeriesName().equals(seriesName)
                    && this.conferenceList.get(i).getYear() == year) {
                return this.conferenceList.get(i);
            }

        }

        return null;
    }

}
