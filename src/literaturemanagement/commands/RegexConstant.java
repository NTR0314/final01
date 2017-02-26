package literaturemanagement.commands;

public interface RegexConstant {

    String GLOBAL = "[^:;,]+";
    String EVENT_NAME = "([A-Za-z\u00e4\u00fc\u00f6\u00c4\u00dc\u00d6])+";
    String PUBLICATION_IDENTIFIER = "[a-z\u00e4\u00fc\u00f6]+[0-9]+";
    String PUBLICATION_IDENTIFIERS_SEMICOLON = "[a-zäüö]+[0-9]+(;[a-zäüö]+[0-9]+)*";
    String PERSON_CITY_NAME = "[A-Z\u00c4\u00d6\u00dca-z\u00fc\u00e4\u00f6]+";
    String YEAR = "\\d\\d\\d\\d";
    String AUTHORS = "[; A-Za-z\u00d6\u00dc\u00c4\u00f6\u00e4\u00fc]+";
    String AUTHOR = "(" + PERSON_CITY_NAME + " " + PERSON_CITY_NAME + ")";
    String AUTHORS_MAX_3 = AUTHOR + "," + AUTHOR + "?," + AUTHOR + "?,";
    String QUIT = "quit";
    String KEYWORDS_WITH_SEMICOLON = "[a-z]+(;?[a-z])*";
    String ADD_AUTHOUR = "add author " + PERSON_CITY_NAME + "," + PERSON_CITY_NAME;
    String ADD_JOURNAL = "add journal " + EVENT_NAME + "," + GLOBAL;
    String ADD_CONFERENCE_SERIES = "add conference series " + EVENT_NAME;
    String ADD_CONFERENCE = "add conference " + EVENT_NAME + "," + YEAR + "," + GLOBAL;
    String ADD_ARTICLE_TOO_SERIES = "add article to series " + EVENT_NAME + ":" + PUBLICATION_IDENTIFIER + "," +
            YEAR + "," + GLOBAL;
    String ADD_ARTICLE_TOO_JOURNAL = "add article to journal " + EVENT_NAME + ":" + PUBLICATION_IDENTIFIER + "," +
            YEAR + "," + GLOBAL;
    String WRITTEN_BY = "written-by " + PUBLICATION_IDENTIFIER + "," + AUTHORS;
    String CITES = "cites " + PUBLICATION_IDENTIFIER + "," + PUBLICATION_IDENTIFIER;
    String ADD_KEYWORDS_TO_PUB = "add keywords to pub " + PUBLICATION_IDENTIFIER + ":" + KEYWORDS_WITH_SEMICOLON;
    String ADD_KEYWORDS_TO_SERIES = "add keywords to series " + EVENT_NAME + ":" + KEYWORDS_WITH_SEMICOLON;
    String ADD_KEYWORDS_TO_JOURNAL = "add keywords to journal " + EVENT_NAME + ":" + KEYWORDS_WITH_SEMICOLON;
    String ADD_KEYWORDS_TO_CONFERENCE = "add keywords to conference " + EVENT_NAME
            + "," + YEAR + ":" + KEYWORDS_WITH_SEMICOLON;
    String ALL_PUBLICATIONS = "all publications";
    String LIST_INVALID_PUBLICATIONS = "list invalid publications";
    String PUBLICATIONS_BY = "publications by [; A-Za-zÖÜÄöäü]+";
    String IN_PROCEEDINGS = "in proceedings " + EVENT_NAME + "," + YEAR;
    String FIND_KEYWORDS = "find keywords " + KEYWORDS_WITH_SEMICOLON;
    String LIST_OF_KEYWORDS = "[a-z\u00f6\u00e4\u00fc]+[;a-z\u00f6\u00e4\u00fc]*";
    String JACCARD = "jaccard " + LIST_OF_KEYWORDS + " " + LIST_OF_KEYWORDS;
    String SIMILARITY = "similarity " + PUBLICATION_IDENTIFIER + "," + PUBLICATION_IDENTIFIER;
    String LIST_OF_CITATION_COUNTS = "[0-9]+(;[0-9]+)*";
    String DIRCET_H_INDEX = "direct h-index " + LIST_OF_CITATION_COUNTS;
    String H_INDEX = "h-index " + PERSON_CITY_NAME + " " + PERSON_CITY_NAME;
    String COAUTHORS_OF = "coauthors of " + PERSON_CITY_NAME + " " + PERSON_CITY_NAME;
    String FOREIGN_CITATIONS_OF = "foreign citations of " + PERSON_CITY_NAME + " " + PERSON_CITY_NAME;
    String DIRECT_PRINT_CONFERENCE_IEEE = "direct print conference ieee:" + AUTHORS_MAX_3 + GLOBAL
            + "," + EVENT_NAME + "," + GLOBAL + "," + YEAR;
    String DIRECT_PRINT_CONFERENCE_CHICAGO = "direct print conference chicago:" + AUTHORS_MAX_3 + GLOBAL
            + "," + EVENT_NAME + "," + GLOBAL + "," + YEAR;
    String DIRECT_PRINT_JOURNAL_IEEE = "direct print journal ieee:" + AUTHORS_MAX_3 + GLOBAL +
            "," + GLOBAL + "," + YEAR;
    String DIRECT_PRINT_JOURNAL_CHICAGO = "direct print journal chicago:" + AUTHORS_MAX_3 + GLOBAL +
            "," + GLOBAL + "," + YEAR;
    String PRINT_BIBLIPGRAPHY_IEEE = "print bibliography ieee:" + PUBLICATION_IDENTIFIERS_SEMICOLON;
    String PRINT_BIBLIOGRAPHY_CHICAGO = "print bibliography chicago:" + PUBLICATION_IDENTIFIERS_SEMICOLON;


}
