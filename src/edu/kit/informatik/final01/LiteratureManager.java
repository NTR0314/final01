package edu.kit.informatik.final01;

import edu.kit.informatik.Terminal;
import edu.kit.informatik.final01.commands.CommandArray;
import edu.kit.informatik.final01.lists.*;

public class LiteratureManager {
    private boolean programFlow = true;

    private final AuthorList authorList = new AuthorList();
    private final JournalList journalList = new JournalList();
    private final ConferenceSeriesList conferenceSeriesList = new ConferenceSeriesList();
    private final ConferenceList conferenceList = new ConferenceList();
    private final ArticleList articleList = new ArticleList();

    /**
     * Main Methode für das Programm hier werden solange Befehle ausgelesen, bis ein Quit Command kommt.
     * @param args ????
     */
    public static void main(String[] args) {

        LiteratureManager literatureManager = new LiteratureManager();
        while (literatureManager.programFlow) {
            literatureManager.runCommands(Terminal.readLine());
        }
    }

    /**
     * Die Methode vergleicht die Eingabezeilen mit den Regex von den Kommandos. Stimmt dieser überein, so wird das
     * Kommando ausgeführt
     * @param command eine Zeile als Eingabe
     */
    public void runCommands(String command) {
        for (int j = 0; j < CommandArray.COMMANDS.length; j++) {
            if (command.matches(CommandArray.COMMANDS[j].getRegex())) {
                CommandArray.COMMANDS[j].execute(this, command);
                return;
            }

        }

        Terminal.printError("Command not found!");
    }

    /**
     * @param programFlow setzt den Programmfluss fest ob, falls true läuft das Programm sonst nicht.
     */
    public void setProgramFlow(boolean programFlow) {
        this.programFlow = programFlow;
    }

    /**
     * @return Gibt die Liste aller Autoren des LiteraturManagements zurück
     */
    public AuthorList getAuthorList() {
        return authorList;
    }

    /**
     * @return Gibt die Liste aller Journals des LiteraturManagements zurück
     */
    public JournalList getJournalList() {
        return journalList;
    }

    /**
     * @return Gibt die Liste aller Konferenz-Serien des LiteraturManagements zurück
     */
    public ConferenceSeriesList getConferenceSeriesList() {
        return conferenceSeriesList;
    }

    /**
     * @return Gibt die Liste aller Konferenzen de LiteraturManagements zurück
     */
    public ConferenceList getConferenceList() {
        return conferenceList;
    }

    /**
     * @return Gibt die Liste aller Artikel des LiteraturManagements zurück
     */
    public ArticleList getArticleList() {
        return articleList;
    }
}
