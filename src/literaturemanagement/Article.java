package literaturemanagement;

import literaturemanagement.venues.Venue;

import java.util.ArrayList;

public class Article extends Publication {
    private final Venue venue;
    private final String[] localKeywords; //Exception Kleinbuchstaben & keine Buchstabe
    private final String[] keywords;

    public Article(String identifier, String title, int yearOfPublication, Author[] authors, Venue venue, String[] localKeywords, String[] keywords) {
        super(identifier, title, yearOfPublication, authors);
        this.venue = venue;
        this.localKeywords = localKeywords;
        this.keywords = MyUtil.addTwoStringArrays(localKeywords, venue.getKeywords());
    }
}
