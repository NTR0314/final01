package literaturemanagement;

public class Publication {
    private final String identifier;
    private final String title;
    private final int yearOfPublication;
    private final Author autors[];

    public Publication(String identifier, String title, int yearOfPublication, Author[] authors) {
        this.identifier = identifier;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.autors = authors;
    }
}