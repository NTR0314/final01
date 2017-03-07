package edu.kit.informatik.final01.lists;

import edu.kit.informatik.final01.entities.Author;

import java.util.ArrayList;

public class AuthorList {

    private final ArrayList<Author> authorList = new ArrayList<>();

    /**
     * Die Methode fügt einen Autor zu dieser AutorListe hinzu
     * @param author Der Autor der hinzugefügt werden soll
     */
    public void addAuthor(Author author) {
        this.authorList.add(author);
    }

    /**
     * Die Methode gibt den Autor an einem bestimmten Index zurück
     * @param index der geuchte Index
     * @return Der gesuchte Autor
     */
    public Author getAtIndex(int index) {
        return this.authorList.get(index);
    }

    /**
     * @return gibt die ArrayList der Autoren zurück die in dieser Liste steckt
     */
    public ArrayList<Author> getAuthorList() {
        return authorList;
    }

    /**
     * Die Methode checkt, ob ein Autor in dieser AutorListe vorhanden ist
     * @param author Der Autor nach dem gesucht wird
     * @return true, falls vorhandem
     *          false, sonst
     */
    public boolean contains(Author author) {
        for (Author anAuthorList : this.authorList) {
            if (anAuthorList.getIdentifier().equals(author.getIdentifier())) {
                return true;

            }
        }
        return false;
    }

    /**
     * Die Methode gibt die Länge dieser AutorenListe zurück
     * @return die Länge dieser AutorenListe
     */
    public int getLength() {
        return this.authorList.size();
    }
}
