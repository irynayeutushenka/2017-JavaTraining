/**
 * Represents the Fixed list of supported languages
 *
 * @author Iryna_Yeutushenka
 */

package com.javatraining.lesson2.language;

public enum Language {
    ENGLISH("English"),
    SPANISH("Spanish");

    private final String representation;

    Language(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return this.representation;
    }
}
