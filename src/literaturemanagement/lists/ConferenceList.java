package literaturemanagement.lists;

import literaturemanagement.entities.Conference;

import java.util.ArrayList;

public class ConferenceList {

    private final ArrayList<Conference> conferenceList = new ArrayList<>();

    public void addConference(Conference conference) {
        this.conferenceList.add(conference);
    }

    public boolean containsAtYear(Conference conference) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getSeriesName().equals(conference.getSeriesName()) &&
                    this.getAtIndex(i).getYear() == conference.getYear()) {
                return true;
            }

        }

        return false;

    }

    public boolean containsAtYear(String name, int year) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getSeriesName().equals(name) &&
                    this.getAtIndex(i).getYear() == year) {
                return true;
            }

        }

        return false;

    }

    public boolean contains(String name) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getSeriesName().equals(name)) {
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

    public Conference getConference(String seriesName, int year) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.conferenceList.get(i).getSeriesName().equals(seriesName)
                    && this.conferenceList.get(i).getYear() == year) {
                return this.conferenceList.get(i);
            }

        }

        return null;
    }

    public ConferenceList inYear(int year) {
        ConferenceList cL = new ConferenceList();

        for (int i = 0; i < this.getLength(); i++) {
            if (this.conferenceList.get(i).getYear() == year) {
                cL.addConference(this.conferenceList.get(i));
            }
        }

        return cL;
    }
}
