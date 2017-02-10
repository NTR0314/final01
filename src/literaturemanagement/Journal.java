package literaturemanagement;

public class Journal {
    private final String title;
    private final String topic;
    private final int year;



    public Journal(String topic, String title, int year) {
        this.topic = topic;
        this.title = title;
        this.year = year;
    }
}
