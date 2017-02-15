package literaturemanagement;

import literaturemanagement.commands.RegexConstant;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        double test = (double)58/7;

        String test2 = String.format(Locale.UK, "%.3f", ((int) (test * 1000) / 1000.0f));

        System.out.println(test);
        System.out.println(test2);
    }
}
