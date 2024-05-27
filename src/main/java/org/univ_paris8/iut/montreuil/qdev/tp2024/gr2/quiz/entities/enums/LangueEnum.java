package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums;

public enum LangueEnum {
    FR("français"),
    EN("english"),
    IT("italia"),
    ES("espagnol"),
    DE("deutsch");

    private final String description;

    LangueEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
