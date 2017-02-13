package literaturemanagement.commands;

import literaturemanagement.LiteratureManager;

public class AddKeywordsTo extends Command {
    protected AddKeywordsTo() {
        super(RegexConstant.ADD_KEYWORDS_TO);
    }

    @Override
    public String cutString(String input) {
        return cutStringHelper(input, 3);
    }

    @Override
    public void execute(LiteratureManager literatureManager, String input) {
        String cutInput = cutString(input);

        String[] splitCutInput = cutInput.split(" |;|:");

        String entityType = splitCutInput[0];
        String nameOrId = splitCutInput[1];
        // alles danach sind Keywörter

        if (entityType.equals("pub")) {
            for (int i = 2; i < splitCutInput.length; i++) {

                literatureManager.getArticleList().getArticle(nameOrId).getKeywordList().addKeyword(splitCutInput[i]);
            }
        }

    }
}
