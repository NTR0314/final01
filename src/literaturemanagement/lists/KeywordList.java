package literaturemanagement.lists;

import literaturemanagement.MyUtil;

import java.util.ArrayList;

public class KeywordList {
    private ArrayList<String> keywordList = new ArrayList<>();

    public KeywordList() {
    }

    public KeywordList(String[] keywordArray) {
        for (int i = 0; i < keywordArray.length; i++) {
            this.keywordList.add(keywordArray[i]);

        }
    }

    public void addKeyword(String keywordToAdd) {
        if (!MyUtil.checkForKeywords(this.keywordList, keywordToAdd))
            this.keywordList.add(keywordToAdd);
    }

    public String getAtIndex(int index) {
        return this.keywordList.get(index);
    }

    public boolean contains(String keyword) {
        for (int i = 0; i < this.keywordList.size(); i++) {
            if (this.getAtIndex(i).equals(keyword)) {
                return true;
            }
        }

        return false;
    }

    public int getLength() {
        return this.keywordList.size();
    }
}
