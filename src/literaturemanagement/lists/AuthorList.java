package literaturemanagement.lists;

import literaturemanagement.entities.Author;

import java.util.ArrayList;

public class AuthorList {

    private final ArrayList<Author> authorList = new ArrayList<>();

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
        for (Author anAuthorList : this.authorList) {
            if (anAuthorList.getIdentifier().equals(author.getIdentifier())) {
                return true;

            }
        }
        return false;
    }

    public int getLength() {
        return this.authorList.size();
    }
}
