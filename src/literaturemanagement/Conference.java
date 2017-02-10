package literaturemanagement;

public class Conference {
    private final String title;
    private final String topic;
    private final int year;
    private final Article articles[];
    private final String localKeywords[]; //Exception Kleinbuchstaben & keine Buchstabe
    private final String Keywords[];

    public Conference(String title, String topic, int year, Article[] articles, String[] localKeywords, String[] keywords) {
        this.title = title;
        this.topic = topic;
        this.year = year;
        this.articles = articles;
        this.localKeywords = localKeywords;
    }
}
