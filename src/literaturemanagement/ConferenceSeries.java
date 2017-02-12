package literaturemanagement;

import literaturemanagement.venues.Conference;

import java.util.ArrayList;

public class ConferenceSeries {
    private ArrayList<Conference> conferences[];

    private final String name;

    private ArrayList<String> keywords;

    public ConferenceSeries(String name) {
        this.name = name;
    }

}
