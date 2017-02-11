package literaturemanagement.venues;

public abstract class Venue {
    private final String title;
    private final String topic;
    private final int year;
    private final String[] localKeywords;
    private String[] keywords; //Exception Kleinbuchstaben & keine Buchstabe

    protected Venue(String title, String topic, int year, String[] localKeywords) {
        this.title = title;
        this.topic = topic;
        this.year = year;
        this.localKeywords = localKeywords;
        this.keywords = localKeywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public String[] getKeywords() {
        return keywords;
    }


}
