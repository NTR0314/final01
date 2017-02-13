package literaturemanagement.system;

import literaturemanagement.Author;

import java.util.ArrayList;

public class AuthorList {

    private ArrayList<Author> authorList = new ArrayList<>();

    public void addAuthor(Author author) {
        this.authorList.add(author);
    }

    public Author getAtIndex(int index) {
        return this.authorList.get(index);
    }

    public ArrayList<Author> getAuthorList() {
        return authorList;
    }
}
