package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums;

public enum NiveauDifficulteQuestion {
    Simple(1),intermedaire(2),expert(3);
    private final int valeur;

    private NiveauDifficulteQuestion(int valeur) {
        this.valeur = valeur;
    }

    public int getValeur() {
        return this.valeur;
    }
}
