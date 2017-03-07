package edu.kit.informatik.final01.entities;

import edu.kit.informatik.final01.lists.ConferenceList;

public class ConferenceSeries extends Venue {
    private final ConferenceList conferences = new ConferenceList();

    /**
     * Konstruktor für eine Konferenz-Serie
     * @param name Name der Konferenz-Serie
     */
    public ConferenceSeries(String name) {
        super(name);
    }

    /**
     * @return gibt den Namen der Konferenz-Serie zurück
     */
    public String getName() {
        return name;
    }

    /**
     * Die Methode fügt eine Konferenz zu der Konferenz-Serie hinzu
     * @param conference Die Konferenz die hinzugefügt werden soll
     */
    public void add(Conference conference) {
        this.conferences.addConference(conference);

        conference.addKeywords(this.keywords);
    }

    /**
     * Die Methode für ein Schlüsselwort zu der Konferenz-Serie hinzu
     * @param keyword das Schlüsselwort das hinzugefügt werden sollte
     */
    public void addKeyword(String keyword) {
        this.keywords.addKeyword(keyword);

        for (int i = 0; i < this.conferences.getLength(); i++) {
            this.conferences.getAtIndex(i).addKeyword(keyword);
        }
    }

    /**
     * @return gibt die Konferenzen zurück, die die Konferenz-Serie enthält
     */
    public ConferenceList getConferences() {
        return conferences;
    }

    /**
     * Die Methode überprüft ob die Konferenz-Serie einen bestimmten Artikel enthält
     * @param articleId Der Artikel nach dem geschaut werden soll
     * @return wahr, falls der Artikel vorhanden ist
     *         falsch, sonst
     */
    public boolean contains(String articleId) {
        for (int i = 0; i < this.conferences.getLength(); i++) {
            if (this.conferences.getAtIndex(i).contains(articleId)) {
                return true;
            }
        }

        return false;
    }

    /**
     * @param year das Jahr an dem die gesuchte Konferenz ist
     * @return gibt die Konferenz aus der Konferenz-Serie zu einem bestimmten Jahr zurück
     */
    public Conference getConference(int year) {
        return this.conferences.getConference(this.name, year);
    }
}
