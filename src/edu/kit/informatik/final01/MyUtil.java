package edu.kit.informatik.final01;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.lists.KeywordList;

import java.util.ArrayList;
import java.util.Locale;

public class MyUtil {

    /**
     * Die Methode checkt ob ein Keyword in einer KeywordListe vorhanden ist
     * @param keywordList die Liste an Keywords bei denen gsucht werden soll in einer String ArrayList
     * @param keywordToLookFor das gesucht keywords
     * @return true, falls vorhanden.
     *         false, sonst.
     */
    public static boolean checkForKeywords(ArrayList<String> keywordList, String keywordToLookFor) {
        for (String anArrayList : keywordList) {
            if (anArrayList.equals(keywordToLookFor)) {
                return true;
            }

        }

        return false;

    }

    /**
     * Die Methode schneidet eine Zahl auf 3 Nachkommastellen ab
     * @param number Die Zahl die abgeschnitten werden soll
     * @return ein String aus der abgeschnittenen Zahl
     */
    public static String formatTo3AfterCommaNumbers(double number) {
        return String.format(Locale.UK, "%.3f", ((int) (number * 1000) / 1000.0f));
    }

    /**
     * Die Methode berechent dan JaccardKoeffizienten zwischen 2 Listen von Schlüsselwörtern
     * @param k1 Liste 1 von Schlüsselwörtern
     * @param k2 Liste 2 von Schlüssekwörtern
     * @return der JaccardKoeffizient
     */
    public static String jaccard(KeywordList k1, KeywordList k2) {
        if (k1.getLength() == 0 && k2.getLength() == 0) {
            Terminal.printLine("1.000");
        }

        double result = ((double) k1.intersection(k2).getLength() / (double) k1.union(k2).getLength());

        return formatTo3AfterCommaNumbers(result);

    }

    /**
     * Berechnet den hIndex mit gegebenen Ganzzahl Array welche die Referenzen darstellen
     * @param citationCounts Die Referenzenanzahl in einem Integer Array zusammengefasst
     * @return der hIndex
     */
    public static int hIndex(int[] citationCounts) {
        int hIndex = 0;

        for (int i = 1; i <= citationCounts.length; i++) {
            int hIndexHelper = 0;

            for (int citationCount : citationCounts) {
                if (i <= citationCount) {
                    hIndexHelper++;
                }

                if (hIndexHelper >= i) {
                    hIndex++;
                    break;
                }


            }

        }

        return hIndex;

    }

    /**
     * Die Methode checkt ob ein Jahr valide ist
     * @param year das Jahr in einem String
     * @return true, fallst ja
     *         false sonst
     */
    public static boolean isValidYear(String year) {
        return Integer.parseInt(year) > 999 && Integer.parseInt(year) < 10000;

    }

    /**
     * Die Methode wandelt ein String Array in ein Integer Array um
     * @param sA das String Array
     * @return das Integer Array
     */
    public static int[] stringToIntArray(String[] sA) {
        int[] iA = new int[sA.length];

        for (int i = 0; i < sA.length; i++) {
            iA[i] = Integer.parseInt(sA[i]);

        }

        return iA;
    }

}
