package literaturemanagement.lists;

import literaturemanagement.entities.Author;

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

    public boolean contains(Author author) {
        for (int i = 0; i < this.authorList.size(); i++) {
            if (this.authorList.get(i).compareTo(author) == 0);
            return true;

        }

        return false;
    }
}
