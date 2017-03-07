package edu.kit.informatik.final01.entities;

public class Author implements Comparable<Author> {
    private final String name;
    private final String lastName;
    private final String identifier;

    /**
     * Konstruktor für einen Autor
     * @param name Der Vorname des Autors
     * @param lastName Der Nachname des Autors
     */
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

    @Override
    public String toString() {
        return name + " " + lastName;
    }

    /**
     * @return gibt den Vornamen des Autors zurück
     */
    public String getName() {
        return name;
    }

    /**
     * @return gibt den Identifier des Autors zurück
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @return gibt den Nachnamen des Autors zurück
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Die Methode überprüft ob zwei Autoren identisch sind
     * @param author der Autor mit dem verglichen werden soll
     * @return wahr, falls die Autoren identisch sind
     *         falsch, sonst
     */
    public boolean isSame(Author author) {
        return this.identifier.equals(author.getIdentifier());

    }

    /**
     * @return gibt den Autorennamen in der Äbkurzungskonvention von IEEE zurück
     */
    public String getIEEEAbr() {
        return String.valueOf(name.charAt(0)).toUpperCase() + ". " + lastName;
    }

    /**
     * @return gibt den Autorennamen in der Abkürzungskonvention von Chicago zurück
     */
    public String getChicagoAbr() {
        return lastName + ", " + name;
    }
}
