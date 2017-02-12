package literaturemanagement.commands;

public interface RegexConstant {

    String EVENT_NAME = "([A-Za-z\u00e4\u00fc\u00f6\u00c4\u00dc\u00d6])+";

    String PUBLICATION_IDENTIFIER = "[a-z\u00e4\u00fc\u00f6]+[0-9]+";

    String PERSON_CITY_NAME = "[A-Z\u00c4\u00d6\u00dc][a-z\u00fc\u00e4\u00f6]+";

    String YEAR = "\\d\\d\\d\\d";

    String TITLE = "[ A-Za-z\u00d6\u00dc\u00c4\u00f6\u00e4\u00fc]+";

    String AUTHORS = "[; A-Za-z\u00d6\u00dc\u00c4\u00f6\u00e4\u00fc]+";

    String VENUE = "journal " + EVENT_NAME + "|conference " + EVENT_NAME + "," + YEAR;

    String QUIT = "quit";

    String ADD_AUTHOUR = "add author " + PERSON_CITY_NAME + "," + PERSON_CITY_NAME;

    String ADD_JOURNAL = "add journal " + EVENT_NAME + "," + EVENT_NAME;

    String ADD_CONFERENCE_SERIES = "add conference series " + EVENT_NAME;

    String ADD_CONFERENCE = "add conference " + EVENT_NAME + "," + YEAR + "," + PERSON_CITY_NAME;

    String ADD_ARTICLE_TOO = "add article to (series|journal) " + EVENT_NAME + ":" + PUBLICATION_IDENTIFIER + "," + YEAR + "," + TITLE;

    String WRITTEN_BY = "written-by " + PUBLICATION_IDENTIFIER + "," + TITLE;


}
