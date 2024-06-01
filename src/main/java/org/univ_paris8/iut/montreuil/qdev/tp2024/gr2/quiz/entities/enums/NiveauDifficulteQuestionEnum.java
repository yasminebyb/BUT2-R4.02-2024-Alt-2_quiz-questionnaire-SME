package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums;

public enum NiveauDifficulteQuestionEnum {
    SIMPLE(1, "Simple"),
    INTERMEDIAIRE(2, "Intermédiaire"),
    EXPERT(3, "Expert");

    private final int niveau;
    private final String description;

    NiveauDifficulteQuestionEnum(int niveau, String description) {
        this.niveau = niveau;
        this.description = description;
    }

    public int getLevel() {
        return niveau;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}