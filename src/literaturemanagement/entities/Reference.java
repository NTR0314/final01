package literaturemanagement.entities;

//TODO vllt brauch ich die Klasse garnicht lol evtl zum sortieren die Methode ung so
//TODO ok ich brauch nur wegen sortirung hab schon anders gelöst LANM

import literaturemanagement.MyUtil;

public class Reference implements Comparable<Reference> {
    private Article article;
    private String shortForm;

    public Reference(Article article, String shortForm) {
        this.article = article;
        this.shortForm = shortForm;
    }

    public Article getArticle() {
        return article;
    }

    @Override
    public int compareTo(Reference reference2) {
        for (int i = 0; i < MyUtil.lengthOfShorterAuthorArrayList(article.getAuthorList().getAuthorList(),
                reference2.getArticle().getAuthorList().getAuthorList()); i++) {
            if (article.getAuthorList().getAtIndex(i).compareTo(reference2.getArticle().getAuthorList().getAtIndex(i)) != 0) {
                return article.getAuthorList().getAtIndex(i).compareTo(reference2.getArticle().getAuthorList().getAtIndex(i));
            }



        }

        return 0;
    }
}
