package literaturemanagement;

public class Article extends Publication {
    public Article(String identifier, String title, int yearOfPublication, Author[] authors) {
        super(identifier, title, yearOfPublication, authors);
    }
}
