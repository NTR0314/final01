package literaturemanagement.entities;

public class Author implements Comparable<Author> {
    private final String name;
    private final String lastName;
    private final String identifier;

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.identifier = name + lastName;
    }

    @Override
    public int compareTo(Author o) {
        if (this.lastName.compareTo(o.lastName) != 0) {
            return this.lastName.compareTo(o.lastName);
        }

        else return this.name.compareTo(o.name);
    }
}