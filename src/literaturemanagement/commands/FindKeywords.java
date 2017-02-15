package literaturemanagement.commands;

import edu.kit.informatik.Terminal;
import literaturemanagement.LiteratureManager;
import literaturemanagement.lists.ArticleList;
import literaturemanagement.lists.KeywordList;

public class FindKeywords extends Command {
    protected FindKeywords() {
        super(RegexConstant.FIND_KEYWORDS);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 2);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);

        String[] splitCutInput = cutInput.split(",");

        KeywordList keywordsToLookFor = new KeywordList(splitCutInput);

        ArticleList articlesWithKeywords = literatureManager.getArticleList().getWithKeywords(keywordsToLookFor);

        Terminal.printLine(articlesWithKeywords.toString());

    }
}
