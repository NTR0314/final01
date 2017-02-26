package literaturemanagement.entities;

import literaturemanagement.lists.KeywordList;

public abstract class Venue {
    final String name;
    final KeywordList keywords = new KeywordList();

    protected Venue(String name) {
        this.name = name;
    }
}
