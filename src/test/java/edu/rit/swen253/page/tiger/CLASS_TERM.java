package edu.rit.swen253.page.tiger;

public enum CLASS_TERM {
    SPRING24_25("2024-25 Spring (2245)"),
    SUMMER24_25("2024-25 Summer (2248)"),
    FALL24_25("2025-26 Fall (2251)"),
    ;

    private final String termText;

    CLASS_TERM(final String termText) {
        this.termText = termText;
    }

    public String getTermText() {
        return termText;
    }
}