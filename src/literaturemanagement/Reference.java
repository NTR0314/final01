package literaturemanagement;

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
        for (int i = 0; i < MyUtil.lengthOfShorterAuthorArray(article.getAuthors(), reference2.getArticle().getAuthors()); i++) {
            if (article.getAuthors()[i].compareTo(reference2.getArticle().getAuthors()[i]) != 0) {
                return article.getAuthors()[i].compareTo(reference2.getArticle().getAuthors()[i]);
            }



        }

        return 0;
    }
}
