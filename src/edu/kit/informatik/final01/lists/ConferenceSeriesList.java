package edu.kit.informatik.final01.lists;

import edu.kit.informatik.final01.entities.ConferenceSeries;

import java.util.ArrayList;

public class ConferenceSeriesList {
    private final ArrayList<ConferenceSeries> conferenceSeriesList = new ArrayList<>();

    /**
     * Die Methode fügt eine neue Konferenz-Serie zu dieser Liste hinzu
     * @param conferenceSeries Die Konferenz-Serie die hinzugefügt werden soll.
     */
    public void addConferenceSeries(ConferenceSeries conferenceSeries) {
        this.conferenceSeriesList.add(conferenceSeries);
    }

    /**
     * Die Methode gibt eine gesuchte Konferenzserie aus der Liste zurück
     * @param nameAsIdentifier der identifier der gesuchten KonferenzSerie
     * @return Die gesuchte KonferenzSerie, falls vorhanden.
     *         null sonst.
     */
    public ConferenceSeries getConferenceSeries(String nameAsIdentifier) {
        for (ConferenceSeries aConferenceSeriesList : this.conferenceSeriesList) {
            if (aConferenceSeriesList.getName().equals(nameAsIdentifier)) {
                return aConferenceSeriesList;
            }
        }
        return null;
    }

    /**
     * Die Methode gibt die Länge der Liste zurück
     * @return die Länge der Liste
     */
    public int getLength() {
        return this.conferenceSeriesList.size();
    }

    /**
     * Die Methode prüft ob eine Konferenzserie in dieser Lite vorhanden ist.
     * @param conferenceSeries die gesuchte Konferenzserie
     * @return true, falls vorhanden.
     *         false, sonst.
     */
    public boolean contains(ConferenceSeries conferenceSeries) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getName().equals(conferenceSeries.getName())) {
                return true;
            }

        }

        return false;
    }

    /**
     * Die Methode prüft ob eine gesuchte KonferenzSerie in dieser Liste vorhanden ist.
     * @param conferenceSeriesName der Name der gesuchten Konferenzserie
     * @return true, fallse vorhandem.
     *         false, sonst.
     */
    public boolean contains(String conferenceSeriesName) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getName().equals(conferenceSeriesName)) {
                return true;
            }

        }

        return false;
    }

    /**
     * Die Methode gibt eine Konferenenz-Serie an gegebenem Index zurück
     * @param index der gegebene Index
     * @return Die KonferenzSerie an gesuchtem index
     */
    public ConferenceSeries getAtIndex(int index) {
        return this.conferenceSeriesList.get(index);
    }
}
