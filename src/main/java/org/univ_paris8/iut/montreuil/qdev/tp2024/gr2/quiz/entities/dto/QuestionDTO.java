package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.NiveauDifficulteQuestionEnum;

import java.util.Objects;

public class QuestionDTO {

    private int numeroQuestion;
    private LangueEnum langue;
    private String libelle;
    private String reponse;
    private NiveauDifficulteQuestionEnum difficulte;

    public QuestionDTO(int numeroQuestion, NiveauDifficulteQuestionEnum difficulte, String libelle, String reponse, LangueEnum langue) {
        this.numeroQuestion = numeroQuestion;
        this.difficulte = difficulte;
        this.libelle = libelle;
        this.reponse = reponse;
        this.langue = langue;
    }

    public int getNumeroQuestion() {
        return numeroQuestion;
    }
    public NiveauDifficulteQuestionEnum getDifficulte() {
        return difficulte;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getReponse() {
        return reponse;
    }

    public LangueEnum getLangue() {
        return langue;
    }

    public void setNumeroQuestion(int numeroQuestion) {
        this.numeroQuestion = numeroQuestion;
    }

    public void setDifficulte(NiveauDifficulteQuestionEnum difficulte) {
        this.difficulte = difficulte;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public void setLangue(LangueEnum langue) {
        this.langue = langue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionDTO that = (QuestionDTO) o;
        return numeroQuestion == that.numeroQuestion && difficulte == that.difficulte && libelle.equals(that.libelle) && reponse.equals(that.reponse) && langue == that.langue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroQuestion, difficulte, libelle, reponse, langue);
    }
}
