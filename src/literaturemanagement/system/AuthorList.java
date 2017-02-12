package literaturemanagement.system;

import literaturemanagement.Author;

import java.util.ArrayList;

public class AuthorList {

    private ArrayList<Author> authorList = new ArrayList<>();

    public void addAuthor(Author author) {
        this.authorList.add(author);
    }
}
