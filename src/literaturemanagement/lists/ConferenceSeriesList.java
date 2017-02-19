package literaturemanagement.lists;

import edu.kit.informatik.Terminal;
import literaturemanagement.entities.ConferenceSeries;

import java.util.ArrayList;

public class ConferenceSeriesList {
    private ArrayList<ConferenceSeries> conferenceSeriesList = new ArrayList<>();

    public void addConferenceSeries(ConferenceSeries conferenceSeries) {
        this.conferenceSeriesList.add(conferenceSeries);
    }

    public ConferenceSeries getConferenceSeries(String nameAsIdentifier) {
        for (int i = 0; i < this.conferenceSeriesList.size(); i++) {
            if (this.conferenceSeriesList.get(i).getName().equals(nameAsIdentifier)) {
                return this.conferenceSeriesList.get(i);
            }
        }
        Terminal.printError("ConferenceSeries not found");
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
