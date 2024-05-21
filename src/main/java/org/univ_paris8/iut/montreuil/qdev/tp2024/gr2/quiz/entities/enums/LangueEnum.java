package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums;

public enum LangueEnum {

    français("fr"),english("en"),espana("es"),deutsh("de"),italia("it");

    private final String valeur;

    private LangueEnum(String valeur) {
        this.valeur = valeur;
    }

    public String getValeur() {
        return this.valeur;
    }

}
