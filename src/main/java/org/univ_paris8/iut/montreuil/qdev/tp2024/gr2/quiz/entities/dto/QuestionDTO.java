package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.NiveauDifficulteQuestionEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.NiveauDifficulteQuestionEnum;

import java.util.Objects;

public class QuestionDTO {
    private int numeroQuestion;
    private LangueEnum langue;
    private String libelle;
    private String reponse;
    private NiveauDifficulteQuestionEnum difficulte;

    // Constructeur
    public QuestionDTO(int numeroQuestion, NiveauDifficulteQuestionEnum difficulte, String libelle, String reponse, LangueEnum langue) {
        this.numeroQuestion = numeroQuestion;
        this.difficulte = difficulte;
        this.libelle = libelle;
        this.reponse = reponse;
        this.langue = langue;
    }

    // Getters et Setters
    public int getNumeroQuestion() {
        return numeroQuestion;
    }

    public void setNumeroQuestion(int numeroQuestion) {
        this.numeroQuestion = numeroQuestion;
    }

    public LangueEnum getLangue() {
        return langue;
    }

    public void setLangue(LangueEnum langue) {
        this.langue = langue;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public NiveauDifficulteQuestionEnum getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(NiveauDifficulteQuestionEnum difficulte) {
        this.difficulte = difficulte;
    }

    // equals et hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionDTO that = (QuestionDTO) o;
        return numeroQuestion == that.numeroQuestion && langue == that.langue && Objects.equals(libelle, that.libelle) && Objects.equals(reponse, that.reponse) && difficulte == that.difficulte;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroQuestion, langue, libelle, reponse, difficulte);
    }
}