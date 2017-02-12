package literaturemanagement;

import literaturemanagement.commands.RegexConstant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String test = "add article to series ICSA:rr2017,2017,Components still have no interfaces";

        String test2 = "arschloch";

        Pattern testpattern = Pattern.compile(RegexConstant.ADD_ARTICLE_TOO);

        Pattern testpattern2 = Pattern.compile("hurensohn|arschloch");

        Matcher m = testpattern.matcher(test);

        Matcher m2 = testpattern2.matcher(test2);

        System.out.println(m.matches());

        System.out.println(m2.matches());


    }
}
