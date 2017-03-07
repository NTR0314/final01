package edu.kit.informatik.final01.commands;

public class RegexConstant {

    private static final String GLOBAL = "[^;,]+";
    private static final String GLOBAL_WITH_DOUBLEPOINT = "[^;:,]+";
    private static final String PUBLICATION_IDENTIFIER = "[a-z\u00e4\u00fc\u00f6]+[0-9]*";
    private static final String PUBLICATION_IDENTIFIERS_SEMICOLON = "[a-zäüö]+[0-9]+(;[a-zäüö]+[0-9]+)*";
    private static final String PERSON_CITY_NAME = "[A-Za-z]+";
    private static final String YEAR = "\\d\\d\\d\\d";
    private static final String AUTHORS = "[; A-Za-z\u00d6\u00dc\u00c4\u00f6\u00e4\u00fc]+";
    private static final String AUTHOR = "(" + PERSON_CITY_NAME + " " + PERSON_CITY_NAME + ")";
    private static final String AUTHORS_MAX_3 = AUTHOR + "," + AUTHOR + "?," + AUTHOR + "?,";
    private static final String KEYWORDS_WITH_SEMICOLON = "[a-z]+(;?[a-z])*";
    private static final String LIST_OF_KEYWORDS = "[a-z\u00f6\u00e4\u00fc]+(;[a-z\u00f6\u00e4\u00fc]+)*";
    private static final String LIST_OF_CITATION_COUNTS = "[0-9]+(;[0-9]+)*";
    /**
     * Regex für das Kommando "quit"
     */
    public static final String QUIT = "quit";
    /**
     * Regex für das Kommando "add author"
     */
    public static final String ADD_AUTHOUR = "add author " + PERSON_CITY_NAME + "," + PERSON_CITY_NAME;
    /**
     * Regex für das Kommando "add journal"
     */
    public static final String ADD_JOURNAL = "add journal " + GLOBAL + "," + GLOBAL;
    /**
     * Regex für das Kommando "add conference series"
     */
    public static final String ADD_CONFERENCE_SERIES = "add conference series " + GLOBAL;
    /**
     * Regex für das Kommando "add conference"
     */
    public static final String ADD_CONFERENCE = "add conference " + GLOBAL + "," + YEAR + "," + GLOBAL;
    /**
     * Regex für das Kommando "add article to series"
     */
    public static final String ADD_ARTICLE_TOO_SERIES = "add article to series " + GLOBAL_WITH_DOUBLEPOINT + ":"
            + PUBLICATION_IDENTIFIER + "," + YEAR + "," + GLOBAL;
    /**
     * Regex für das Kommando "add article to journal"
     */
    public static final String ADD_ARTICLE_TOO_JOURNAL = "add article to journal " + GLOBAL_WITH_DOUBLEPOINT + ":"
            + PUBLICATION_IDENTIFIER + "," + YEAR + "," + GLOBAL;
    /**
     * Regex für das Kommando "written by"
     */
    public static final String WRITTEN_BY = "written-by " + PUBLICATION_IDENTIFIER + "," + AUTHORS;
    /**
     * Regex für das Kommando "cities"
     */
    public static final String CITES = "cites " + PUBLICATION_IDENTIFIER + "," + PUBLICATION_IDENTIFIER;
    /**
     * Regex für das Kommando "add keywords to pub"
     */
    public static final String ADD_KEYWORDS_TO_PUB = "add keywords to pub " + PUBLICATION_IDENTIFIER + ":"
            + KEYWORDS_WITH_SEMICOLON;
    /**
     * Regex für das Kommando "add keywords to series"
     */
    public static final String ADD_KEYWORDS_TO_SERIES = "add keywords to series " + GLOBAL + ":" + KEYWORDS_WITH_SEMICOLON;
    /**
     * Regex für das Kommando "add keywords to journal"
     */
    public static final String ADD_KEYWORDS_TO_JOURNAL = "add keywords to journal " + GLOBAL + ":"
            + KEYWORDS_WITH_SEMICOLON;
    /**
     * Regex für das Kommando "add keywords to conference"
     */
    public static final String ADD_KEYWORDS_TO_CONFERENCE = "add keywords to conference " + GLOBAL
            + "," + YEAR + ":" + KEYWORDS_WITH_SEMICOLON;
    /**
     * Regex für das Kommando "all publications
     */
    public static final String ALL_PUBLICATIONS = "all publications";
    /**
     * Regex für das Kommando "list invalid publications
     */
    public static final String LIST_INVALID_PUBLICATIONS = "list invalid publications";
    /**
     * Regex für das Kommando "publications by"
     */
    public static final String PUBLICATIONS_BY = "publications by [; A-Za-zÖÜÄöäü]+";
    /**
     * Regex für das Kommando "in proceedings"
     */
    public static final String IN_PROCEEDINGS = "in proceedings " + GLOBAL + "," + YEAR;
    /**
     * Regex für das Kommando "find keywords"
     */
    public static final String FIND_KEYWORDS = "find keywords " + KEYWORDS_WITH_SEMICOLON;
    /**
     * Regex für das Kommando "jaccard"
     */
    public static final String JACCARD = "jaccard " + LIST_OF_KEYWORDS + " " + LIST_OF_KEYWORDS;
    /**
     * Regex für das Kommando "similarity"
     */
    public static final String SIMILARITY = "similarity " + PUBLICATION_IDENTIFIER + "," + PUBLICATION_IDENTIFIER;
    /**
     * Regex für das Kommando "direct h-index"
     */
    public static final String DIRCET_H_INDEX = "direct h-index " + LIST_OF_CITATION_COUNTS;
    /**
     * Regex für das Kommando "h-index"
     */
    public static final String H_INDEX = "h-index " + PERSON_CITY_NAME + " " + PERSON_CITY_NAME;
    /**
     * Regex für das Kommando "coauthors of"
     */
    public static final String COAUTHORS_OF = "coauthors of " + PERSON_CITY_NAME + " " + PERSON_CITY_NAME;
    /**
     * Regex für das Kommando "foreign citations of"
     */
    public static final String FOREIGN_CITATIONS_OF = "foreign citations of " + PERSON_CITY_NAME + " " + PERSON_CITY_NAME;
    /**
     * Regex für das Kommando "direct print conference ieee
     */
    public static final String DIRECT_PRINT_CONFERENCE_IEEE = "direct print conference ieee:" + AUTHORS_MAX_3 + GLOBAL
            + "," + GLOBAL + "," + GLOBAL + "," + YEAR;
    /**
     * Regex für das Kommando "direct print conference chicago"
     */
    public static final String DIRECT_PRINT_CONFERENCE_CHICAGO = "direct print conference chicago:" + AUTHORS_MAX_3 + GLOBAL
            + "," + GLOBAL + "," + GLOBAL + "," + YEAR;
    /**
     * Regex für das Kommando "direct print journal ieee"
     */
    public static final String DIRECT_PRINT_JOURNAL_IEEE = "direct print journal ieee:" + AUTHORS_MAX_3 + GLOBAL
            + "," + GLOBAL + "," + YEAR;
    /**
     * Regex für das Kommando "direct print journal chicago"
     */
    public static final String DIRECT_PRINT_JOURNAL_CHICAGO = "direct print journal chicago:" + AUTHORS_MAX_3 + GLOBAL
            + "," + GLOBAL + "," + YEAR;
    /**
     * Regex für das Kommando "print bibliography ieee"
     */
    public static final String PRINT_BIBLIOPGRAPHY_IEEE = "print bibliography ieee:" + PUBLICATION_IDENTIFIERS_SEMICOLON;
    /**
     * Regex für das Kommando "print bibliography chicago"
     */
    public static final String PRINT_BIBLIOGRAPHY_CHICAGO = "print bibliography chicago:" + PUBLICATION_IDENTIFIERS_SEMICOLON;


}
