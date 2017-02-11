package literaturemanagement;

public class MyUtil {

    public static String[] addTwoStringArrays(String[] array1, String[] array2) {
        String[] result = new String[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i];
            result[i + array1.length] = array2[i];
        }

        return result;
    }

}
