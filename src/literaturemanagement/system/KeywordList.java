package literaturemanagement.system;

import literaturemanagement.MyUtil;

import java.util.ArrayList;

public class KeywordList {
    private ArrayList<String> keywordList = new ArrayList<>();

    public void addKeyword(String keywordToAdd) {
        if (!MyUtil.checkForKeywords(this.keywordList, keywordToAdd))
        this.keywordList.add(keywordToAdd);
    }
}
