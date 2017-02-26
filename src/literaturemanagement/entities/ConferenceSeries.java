package literaturemanagement.entities;

import literaturemanagement.lists.ConferenceList;
import literaturemanagement.lists.KeywordList;

public class ConferenceSeries extends Venue{
    private final ConferenceList conferences = new ConferenceList();

    public ConferenceSeries(String name) {
        super(name);
    }

    public String getName() {
        return name;
    }

    public void add(Conference conference) {
        this.conferences.addConference(conference);

        conference.addKeywords(this.keywords);
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

    public boolean contains(String articleId) {
        for (int i = 0; i < this.conferences.getLength(); i++) {
            if (this.conferences.getAtIndex(i).contains(articleId)) {
                return true;
            }
        }

        return false;
    }

    public Conference getConference(int year) {
        return this.conferences.getConference(this.name, year);
    }
}
