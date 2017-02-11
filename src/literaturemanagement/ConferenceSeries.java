package literaturemanagement;

import literaturemanagement.venues.Conference;

import java.util.ArrayList;

public class ConferenceSeries {
    private ArrayList<Conference> conferences[];

    private final String name;

    private final String[] keywords;

    private final String[] localKeywords;

    public ConferenceSeries(ArrayList<Conference>[] conferences, String name, String[] localKeywords) {
        this.conferences = conferences;
        this.name = name;
        this.keywords = localKeywords;
        this.localKeywords = localKeywords;
    }

    public String[] getKeywords() {
        return localKeywords;
    }
}
