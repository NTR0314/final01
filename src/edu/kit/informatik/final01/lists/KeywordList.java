package edu.kit.informatik.final01.lists;

import edu.kit.informatik.final01.MyUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class KeywordList {
    private final ArrayList<String> keywordList = new ArrayList<>();

    /**
     * Konstruktor für eine leere Keyword-Liste ohne jedgliche Elemente
     */
    public KeywordList() {
    }

    /**
     * Konstruktor für eine Keyword-List mit bestimmten Keywords
     * @param keywordArray Die Keywords, die direkt bei der erstellung der Keyword-Liste hinzugefügt werden sollen
     *                    in einem String-Array
     */
    public KeywordList(String[] keywordArray) {
        this.keywordList.addAll(Arrays.asList(keywordArray));
    }

    /**
     * Die Methode fügt der Keyword-Liste ein weiteres Keyword hinzu
     * @param keywordToAdd ein String welches das Keyword darstellt
     */
    public void addKeyword(String keywordToAdd) {
        if (!MyUtil.checkForKeywords(this.keywordList, keywordToAdd))
            this.keywordList.add(keywordToAdd);
    }

    /**
     * Die Methode gibt das Keywoard das an einem bestimmten Index in diese Keyword-Liste gespeichert wurde zurück
     * @param index Der Index an dem gesucht werden soll
     * @return Das gesuchte Keyword
     */
    public String getAtIndex(int index) {
        return this.keywordList.get(index);
    }

    /**
     * Die Methode überprüft ob ein bestimmtes Keyword in dieser Keyword-Liste vorhanden ist.
     * @param keyword das Keyword nach dem gesucht wird als String.
     * @return true, falls das Keyword vorhanden ist.
     *         false, sonst.
     */
    public boolean contains(String keyword) {
        for (int i = 0; i < this.keywordList.size(); i++) {
            if (this.getAtIndex(i).equals(keyword)) {
                return true;
            }
        }

        return false;
    }

    /**
     * @return Die Methode gibt die Länge dieser Keyword-Liste zurück
     */
    public int getLength() {
        return this.keywordList.size();
    }

    /**
     * Die Methode ist eine Hilfmethode für den Jaccard-Koeffizienten, hier wird die Vereinigung zweier Keywordlisten
     * angeschaut. Die Methode fügt zwei Keyword-Listen zusammen ohne Duplikate.
     * @param otherKWList Die andere Keyword-Liste die hinzugefügt werden soll.
     * @return Die Vereinung beider Keyword-Listen
     */
    public KeywordList intersection(KeywordList otherKWList) {
        KeywordList newKWList = new KeywordList();
        for (int i = 0; i < this.getLength(); i++) {
            for (int j = 0; j < otherKWList.getLength(); j++) {
                if (this.keywordList.get(i).equals(otherKWList.getAtIndex(j))) {
                    newKWList.addKeyword(this.keywordList.get(i));
                    break;
                }


            }


        }

        return newKWList;
    }

    /**
     * Diese Methode ist eine Hilfmethode für den Jaccard-Koeffizienten. Hir wird der Schnitt zweier Keyword-Listen
     * berechnet
     * @param otherKWList die zweite KeywordListe mit der geschnitten werden soll
     * @return eine neue Keyword-Liste die den Schnitt der beiden Keyword-Listen darstellt.
     */
    public KeywordList union(KeywordList otherKWList) {
        KeywordList newKWList = new KeywordList();
        for (int i = 0; i < this.getLength(); i++) {
            for (int j = 0; j < otherKWList.getLength(); j++) {
                if (this.keywordList.get(i).equals(otherKWList.getAtIndex(j))) {
                    break;
                }
                
            }

            newKWList.addKeyword(this.keywordList.get(i));
            

        }

        for (int i = 0; i < otherKWList.getLength(); i++) {

            newKWList.addKeyword(otherKWList.getAtIndex(i));

        }

        return newKWList;
    }
}
