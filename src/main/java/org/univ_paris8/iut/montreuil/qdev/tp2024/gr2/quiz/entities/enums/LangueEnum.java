package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums;

public enum LangueEnum {
    FRANCAIS("fr", "français"),
    ENGLISH("en", "english"),
    ITALIAN("it", "italia"),
    ESPAGNOL("es", "espana"),
    DEUTSCH("de", "deutch");

    private final String code;
    private final String label;

    LangueEnum(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}