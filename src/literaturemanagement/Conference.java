package literaturemanagement;

public class Conference {
    private final String title;
    private final String topic;
    private final int year;
    private final String keywords[]; //Exception Kleinbuchstaben & keine Buchstabe

    public Conference(String title, String topic, int year, String[] keywords) {
        this.title = title;
        this.topic = topic;
        this.year = year;
        this.keywords = keywords;
    }
}
