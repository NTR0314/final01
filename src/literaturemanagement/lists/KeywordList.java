package literaturemanagement.lists;

import literaturemanagement.MyUtil;

import java.security.Key;
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

    public KeywordList intersection(KeywordList otherKWList) {
        KeywordList newKWList = new KeywordList();
        for (int i = 0; i < this.getLength(); i++) {
            for (int j = 0; j < otherKWList.getLength(); j++) {
                if (this.keywordList.get(i).equals(otherKWList.getAtIndex(j))) {
                    newKWList.addKeyword(this.keywordList.get(i));
                    break;
                }


            }


        }

        return newKWList;
    }

    public KeywordList union(KeywordList otherKWList) {
        KeywordList newKWList = new KeywordList();
        for (int i = 0; i < this.getLength(); i++) {
            for (int j = 0; j < otherKWList.getLength(); j++) {
                if (this.keywordList.get(i).equals(otherKWList.getAtIndex(j))) {
                    break;
                }
                
            }

            newKWList.addKeyword(this.keywordList.get(i));
            

        }

        for (int i = 0; i < otherKWList.getLength(); i++) {

            newKWList.addKeyword(otherKWList.getAtIndex(i));

        }

        return newKWList;
    }
}
