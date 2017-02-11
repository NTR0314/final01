package literaturemanagement.venues;

import literaturemanagement.Article;
import literaturemanagement.ConferenceSeries;
import literaturemanagement.MyUtil;

public class Conference extends Venue{
    private Article[] articles;
    private ConferenceSeries conferenceSeries;

    public Conference(String title, String topic, int year, String[] localKeywords, Article[] articles, ConferenceSeries conferenceSeries) {
        super(title, topic, year, localKeywords);
        this.setKeywords(MyUtil.addTwoStringArrays(localKeywords, getKeywords()));
        this.articles = articles;
        this.conferenceSeries = conferenceSeries;
    }


}
