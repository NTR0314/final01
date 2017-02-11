package literaturemanagement;

import literaturemanagement.venues.Venue;

public class Article extends Publication {
    private final Venue venue;
    private final String name;
    private final String[] localKeywords; //Exception Kleinbuchstaben & keine Buchstabe
    private final String[] keywords;

    public Article(String identifier, String title, int yearOfPublication, Author[] authors, Venue venue, String[] localKeywords, String[] keywords, String name) {
        super(identifier, title, yearOfPublication, authors);
        this.venue = venue;
        this.localKeywords = localKeywords;
        this.name = name;
        this.keywords = MyUtil.addTwoStringArrays(localKeywords, venue.getKeywords());
    }
}
