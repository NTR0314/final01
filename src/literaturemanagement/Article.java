package literaturemanagement;

public class Article extends Publication {
    private final String keywords[]; //Exception Kleinbuchstaben & keine Buchstabe
    public Article(String identifier, String title, int yearOfPublication, Author[] authors, String[] keywords) {
        super(identifier, title, yearOfPublication, authors);
        this.keywords = keywords;
    }
}
