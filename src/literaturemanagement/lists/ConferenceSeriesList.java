package literaturemanagement.lists;

import literaturemanagement.entities.ConferenceSeries;

import java.util.ArrayList;

public class ConferenceSeriesList {
    private final ArrayList<ConferenceSeries> conferenceSeriesList = new ArrayList<>();

    public void addConferenceSeries(ConferenceSeries conferenceSeries) {
        this.conferenceSeriesList.add(conferenceSeries);
    }

    public ConferenceSeries getConferenceSeries(String nameAsIdentifier) {
        for (ConferenceSeries aConferenceSeriesList : this.conferenceSeriesList) {
            if (aConferenceSeriesList.getName().equals(nameAsIdentifier)) {
                return aConferenceSeriesList;
            }
        }
        return null;
    }

    public int getLength() {
        return this.conferenceSeriesList.size();
    }

    public boolean contains(ConferenceSeries conferenceSeries) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getName().equals(conferenceSeries.getName())) {
                return true;
            }

        }

        return false;
    }

    public boolean contains(String conferenceSeriesName) {
        for (int i = 0; i < this.getLength(); i++) {
            if (this.getAtIndex(i).getName().equals(conferenceSeriesName)) {
                return true;
            }

        }

        return false;
    }

    public ConferenceSeries getAtIndex(int index) {
        return this.conferenceSeriesList.get(index);
    }
}
