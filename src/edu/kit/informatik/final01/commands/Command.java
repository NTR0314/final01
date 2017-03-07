package edu.kit.informatik.final01.commands;

import edu.kit.informatik.final01.LiteratureManager;

import java.util.regex.Pattern;

public abstract class Command {
    private final Pattern p;
    private final String regex;
    /**
     * Konstruktor der abstrakten Klasse "Command"
     * @param regex ist die "regular expression" von dem "Command". Hier werden zum Beispiel die Eingaben begrenzt
     *              Bsp.: Sind bei "keywords" nur Kleinbuchstaben erlaubt.
     */
    protected Command(String regex) {
        p = Pattern.compile(regex);
        this.regex = regex;
    }
    /**
     * @return gibt die "regular expression" des jeweiligen Kommandos in Form eines Strings zurück
     */
    public String getRegex() {
        return regex;
    }
    /**
     * Schneidet bei den Eingaben des Programms die Kommandowörter aber, so dass nurnoch die Informationen da sind.
     * @param input ist hier die Eingabe des Programms
     * @return gibt einen String zurück der nichtmehr die Kommandowörter enthält
     */
    abstract String cutString(String input);
    /**
     * Hier wird das jeweilige Kommando ausgeführt wo auch die Logik enthalten ist
     * @param literatureManager auf diesem "literatureManager" wird das Kommando ausgeführt, beispielweise ein Autor
     *                          hinzugefügt oder so.
     * @param input ist die Eingabe die das Programm erhält.
     */
    public abstract void execute(LiteratureManager literatureManager, String input);
    /**
     * eine Hilfsmethode zum abschneiden von den Kommandowörtern bei der Eingabe
     * @param input Die Eingabe des Programms
     * @param amountOfCommandWords wieviele Wörter (die mit Leerzeichen getrennt sind)vom Anfang
     *                            abgeschnitten werden sollen
     * @return gibt den gekürzten String zurück ohne Kommandowörter
     */
    public String cutStringHelper(String input, int amountOfCommandWords) {
        String[] tempStringArray = input.split(" ", amountOfCommandWords + 1);

        return tempStringArray[amountOfCommandWords];
    }

}
