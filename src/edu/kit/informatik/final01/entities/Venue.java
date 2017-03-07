package edu.kit.informatik.final01.entities;

import edu.kit.informatik.final01.lists.KeywordList;

abstract class Venue {
    /**
     * Der Name des Veröffentlichungsortes
     */
    final String name;
    /**
     * Die Schlüsselwortliste des Veröffentlichungortes
     */
    final KeywordList keywords = new KeywordList();

    /**
     * Konstruktor für ein Veröffentlichungsort
     * @param name Der Name des Veröffentlichungortes
     */
    Venue(String name) {
        this.name = name;
    }
}
