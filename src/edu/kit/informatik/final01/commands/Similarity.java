package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.MyUtil;
import edu.kit.informatik.final01.entities.Article;

public class Similarity extends Command {
    /**
     * Konstruktor des Kommandos "similarity
     */
    Similarity() {
        super(RegexConstant.SIMILARITY);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 1);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutString = cutString(input);

        String[] splitCutString = cutString.split(",");

        String pubid1 = splitCutString[0];
        String pubid2 = splitCutString[1];

        Article a1 = literatureManager.getArticleList().getArticle(pubid1);
        Article a2 = literatureManager.getArticleList().getArticle(pubid2);

        Terminal.printLine(MyUtil.jaccard(a1.getKeywordList(), a2.getKeywordList()));
    }
}
