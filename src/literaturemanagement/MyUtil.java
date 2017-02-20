package literaturemanagement;

import edu.kit.informatik.Terminal;
import literaturemanagement.lists.KeywordList;

import java.util.ArrayList;
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

    public static String formatTo3AfterCommaNumbers(double number) {
        return String.format(Locale.UK, "%.3f", ((int) (number * 1000) / 1000.0f));
    }

    public static String jaccard(KeywordList k1, KeywordList k2) {
        if(k1.getLength() == 0 && k2.getLength() == 0) {
            Terminal.printLine("1.000");
        }

        double result = ((double) k1.intersection(k2).getLength() / (double) k1.union(k2).getLength());

        return formatTo3AfterCommaNumbers(result);

    }

    public static int hIndex(int[] citationCounts) {
        int hIndex = 0;

        for (int i = 1; i <= citationCounts.length; i++) {
            int hIndexHelper = 0;

            for (int j = 0; j < citationCounts.length; j++) {
                if (i <= citationCounts[j]) {
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

    public static int[] stringToIntArray(String[] sA) {
        int[] iA = new int[sA.length];

        for (int i = 0; i < sA.length; i++) {
            iA[i] = Integer.parseInt(sA[i]);

        }

        return iA;
    }

}
