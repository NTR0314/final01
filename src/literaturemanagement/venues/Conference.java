package literaturemanagement.venues;

import literaturemanagement.Article;

import java.util.ArrayList;

public class Conference {

    private final String seriesName;
    private final int year;
    private final String location;
    private ArrayList<Article> articles;

    public Conference(String seriesName, int year, String location) {
        this.seriesName = seriesName;
        this.year = year;
        this.location = location;
    }
}
