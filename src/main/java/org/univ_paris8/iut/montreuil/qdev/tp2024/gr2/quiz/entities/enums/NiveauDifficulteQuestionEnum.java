package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums;

public enum NiveauDifficulteQuestionEnum {

    SIMPLE(1), INTERMEDIAIRE(2), EXPERT(3);

    private final int niveau;

    NiveauDifficulteQuestionEnum(int niveau) {
        this.niveau = niveau;
    }

    public int getNiveau() {
        return niveau;
    }

}
