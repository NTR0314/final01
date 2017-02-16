package literaturemanagement;

import literaturemanagement.commands.RegexConstant;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {

        String[] test = {"8","6","8","4","8","6"};

        System.out.println(MyUtil.hIndex(MyUtil.stringToIntArray(test)));
    }
}
