package literaturemanagement;

import edu.kit.informatik.Terminal;
import literaturemanagement.entities.Reference;
import literaturemanagement.lists.KeywordList;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class MyUtil {

    public static String[] addTwoStringArrays(String[] array1, String[] array2) {
        String[] result = new String[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i];
            result[i + array1.length] = array2[i];
        }

        return result;
    }

    public static int lengthOfShorterAuthorArrayList(ArrayList a, ArrayList b) {
        if (a.size() > b.size()) {
            return a.size();
        }

        if (b.size() > a.size()) {
            return b.size();
        } else return a.size();


    }

    public static void sortReferenceArrayList(ArrayList<Reference> references) {
        for (int i = 0; i < references.size(); i++) {
            for (int j = 0; j < references.size(); j++) {
                if (references.get(j).compareTo(references.get(j + 1)) > 0) {
                    Collections.swap(references, j, j + 1);
                    break;
                }

            }
        }
    }

    /**
     * checkt ob ein Keyword bereits in einer Liste vorhanden ist, falls ja gibt die Methode true zurück
     * sosnt false
     */
    public static boolean checkForKeywords(ArrayList<String> arrayList, String keywordToLookFor) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(keywordToLookFor)) {
                return true;
            }

        }

        return false;

    }

    public static String jaccard(KeywordList k1, KeywordList k2) {
        if(k1.getLength() == 0 && k2.getLength() == 0) {
            Terminal.printLine("1.000");
        }

        double result = (k1.intersection(k2).getLength() / k1.union(k2).getLength());

        return String.format(Locale.UK, "%.3f", ((int) (result * 1000) / 1000.0f));

    }

}
