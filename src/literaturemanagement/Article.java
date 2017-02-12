package literaturemanagement;

public class Article {
    private final String identifier; //besteht aus kleinbuchstaben udn Zahlen
    private final String title;
    private final int yearOfPublication;
    private final Author authors[];
    private final Article article;


    public Article(String identifier, String title, int yearOfPublication, Author[] authors, Article article) {
        this.identifier = identifier;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.authors = authors;
        this.article = article;
    }

    public Author[] getAuthors() {
        return authors;
    }
}
