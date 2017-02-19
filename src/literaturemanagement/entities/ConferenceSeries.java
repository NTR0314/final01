package literaturemanagement.entities;

import literaturemanagement.lists.ConferenceList;
import literaturemanagement.lists.KeywordList;

public class ConferenceSeries {
    private ConferenceList conferences = new ConferenceList();
    private final String name;
    private KeywordList keywords = new KeywordList();

    public ConferenceSeries(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Conference conference) {
        this.conferences.addConference(conference);
    }

    public void addKeyword(String keyword) {
        this.keywords.addKeyword(keyword);

        for (int i = 0; i < this.conferences.getLength(); i++) {
            this.conferences.getAtIndex(i).addKeyword(keyword);
        }
    }

    public ConferenceList getConferences() {
        return conferences;
    }
}
