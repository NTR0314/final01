package literaturemanagement.lists;

import literaturemanagement.entities.Article;
import literaturemanagement.entities.Conference;

import java.util.ArrayList;

public class ConferenceList {

    private ArrayList<Conference> conferenceList = new ArrayList<>();

    public void addConference(Conference conference) {
        this.conferenceList.add(conference);
    }

    public boolean contains(Conference conference) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getSeriesName().equals(conference.getSeriesName()) &&
                    this.getAtIndex(i).getYear() == conference.getYear()) {
                return true;
            }

        }

        return false;

    }

    public boolean contains(String name, int year) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getSeriesName().equals(name) &&
                    this.getAtIndex(i).getYear() == year) {
                return true;
            }

        }

        return false;

    }

    public int getLength() {
        return this.conferenceList.size();
    }

    public Conference getAtIndex(int index) {
        return this.conferenceList.get(index);
    }
    // return null falls nicht vorhanden
    public Conference getWithSeriesName(String seriesName) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.conferenceList.get(i).getSeriesName().equals(seriesName)) {
                return this.conferenceList.get(i);
            }

        }

        return null;
    }
}
