package edu.kit.informatik.final01.commands;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.LiteratureManager;
import edu.kit.informatik.final01.lists.ArticleList;
import edu.kit.informatik.final01.lists.KeywordList;

public class FindKeywords extends Command {
    /**
     * Konstruktor des Kommandos "find keywords"
     */
    FindKeywords() {
        super(RegexConstant.FIND_KEYWORDS);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 2);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);

        String[] splitCutInput = cutInput.split(";");

        KeywordList keywordsToLookFor = new KeywordList(splitCutInput);

        ArticleList articlesWithKeywords = literatureManager.getArticleList().getWithKeywords(keywordsToLookFor);

        for (int i = 0; i < articlesWithKeywords.getLength(); i++) {
            Terminal.printLine(articlesWithKeywords.getAtIndex(i).getIdentifier());

        }

    }
}
