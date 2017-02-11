package literaturemanagement;

public class Reference implements Comparable<Reference>{
    private Publication publication;
    private String shortForm;

    public Publication getPublication() {
        return publication;
    }

    @Override
    public int compareTo(Reference reference2) {
        for (int i = 0; i < MyUtil.lengthOfShorterAuthorArray(publication.getAuthors(), reference2.getPublication().getAuthors()); i++) {
            if (publication.getAuthors()[i].compareTo(reference2.getPublication().getAuthors()[i]) != 0) {
                return publication.getAuthors()[i].compareTo(reference2.getPublication().getAuthors()[i]);
            }



        }

        return 0;
    }
}
