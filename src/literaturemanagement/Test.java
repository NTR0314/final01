package literaturemanagement;

public class Test {
    public static void main(String[] args) {
        String test = "test,,oswald";
        String[] test2 = test.split(",");

        for (int i = 0; i < test2.length; i++) {

            System.out.println(test2[i].isEmpty());
        }
    }

}
