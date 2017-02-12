package literaturemanagement.system;

import literaturemanagement.ConferenceSeries;

import java.util.ArrayList;

public class ConferenceSeriesList {
    private ArrayList<ConferenceSeries> conferenceSeriesList = new ArrayList<>();

    public void addConferenceSeries(ConferenceSeries conferenceSeries) {
        this.conferenceSeriesList.add(conferenceSeries);
    }
}
