package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.MyUtil;
import edu.kit.informatik.final01.lists.KeywordList;

public class Jaccard extends Command {
    /**
     * Konstruktor des Kommandos "jaccard"
     */
    Jaccard() {
        super(RegexConstant.JACCARD);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 1);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutString = cutString(input);
        String[] splitCutString = cutString.split(" ");

        String[] keywordArray1 = splitCutString[0].split(";");
        String[] keywordArray2 = splitCutString[1].split(";");

        Terminal.printLine(MyUtil.jaccard(new KeywordList(keywordArray1), new KeywordList(keywordArray2)));

    }
}
