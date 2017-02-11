package literaturemanagement;

import literaturemanagement.commands.RegexConstant;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String hehexd = "([A-Za-z\u00e4\u00fc\u00f6\u00c4\u00dc\u00d6])+";
        String test = "tÄsST";
        String test2 = "conference HUSO,1998";
        String test3 = "journal KyÄSecksÄDE";

        Pattern testpattern = Pattern.compile(RegexConstant.VENUE);

        Matcher m = testpattern.matcher(test2);

        System.out.println(m.matches());


    }
}
