package literaturemanagement.system;

import literaturemanagement.venues.Conference;

import java.util.ArrayList;

public class ConferenceList {

    private ArrayList<Conference> conferenceList = new ArrayList<>();

    public void addConference(Conference conference) {
        this.conferenceList.add(conference);
    }
}
