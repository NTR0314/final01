package literaturemanagement;

import literaturemanagement.commands.RegexConstant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String test = "mvp2016,Shashi Afolabi;Eniola Lowr";

        String[] test2 = test.split(",|;");
        for (int i = 0; i < test2.length; i++) {
            System.out.println(test2[i]);

        }
    }
}
