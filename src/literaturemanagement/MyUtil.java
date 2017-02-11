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

    public static int lengthOfShorterAuthorArray(Author[] array1, Author[] array2) {
        if (array1.length > array2.length) {
            return array1.length;
        }

        if (array2.length > array1.length) {
            return array2.length;
        } else return array1.length;


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
