package literaturemanagement.system;

import edu.kit.informatik.Terminal;
import literaturemanagement.ConferenceSeries;

import java.util.ArrayList;

public class ConferenceSeriesList {
    private ArrayList<ConferenceSeries> conferenceSeriesList = new ArrayList<>();

    public void addConferenceSeries(ConferenceSeries conferenceSeries) {
        this.conferenceSeriesList.add(conferenceSeries);
    }

    public ConferenceSeries getConferenceSeries(String nameAsIdentifier) {
        for (int i = 0; i < this.conferenceSeriesList.size(); i++) {
            if (this.conferenceSeriesList.get(i).getName() == nameAsIdentifier) {
                return this.conferenceSeriesList.get(i);
            }
        }

        Terminal.printError("ConferenceSeries not found");
        //TODO MICHAEL FRAGU WIE IC HDAS HÄMDLE DASS SEIN KANN DAS KEIN CS GEFUDNEN WIRD WAS DAN RETUNRNEN UND SOOO ;D
        return null;
    }
}
