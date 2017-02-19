package literaturemanagement.entities;

import literaturemanagement.entities.Article;
import literaturemanagement.lists.ArticleList;
import literaturemanagement.lists.ConferenceList;
import literaturemanagement.lists.KeywordList;

import java.util.ArrayList;

public class ConferenceSeries {
    private ConferenceList conferences = new ConferenceList();
    private final String name;
    private KeywordList keywords = new KeywordList();

    public ConferenceSeries(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Conference conference) {
        this.conferences.addConference(conference);
    }
}
