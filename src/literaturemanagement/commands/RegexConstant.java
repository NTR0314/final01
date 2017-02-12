package literaturemanagement.commands;

interface RegexConstant {

    String EVENT_NAME = "([A-Za-z\u00e4\u00fc\u00f6\u00c4\u00dc\u00d6])+";

    String PUBLICATION_IDENTIFIER = "[a-z0-9]+";

    String PERSON_NAME = "[A-Z][a-z]+";

    String YEAR = "\\d\\d\\d\\d";

    String VENUE = "journal " + EVENT_NAME + "|conference " + EVENT_NAME + "," + YEAR;

    String QUIT = "quit";

    String ADD_AUTHOUR = "add author " + PERSON_NAME + "," + PERSON_NAME;

    String ADD_JOURNAL = "add journal " + EVENT_NAME + "," + EVENT_NAME;
}
