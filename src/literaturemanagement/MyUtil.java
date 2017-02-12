package literaturemanagement;

import java.util.ArrayList;
import java.util.Collections;

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

}
