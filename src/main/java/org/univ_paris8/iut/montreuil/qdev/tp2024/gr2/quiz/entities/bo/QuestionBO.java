package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.bo;

import java.util.Objects;

public class QuestionBO {

    private int id;
    private int num;
    private String langue;
    private String question;
    private String reponse;
    private int difficulte;
    private String explication;
    private String reference;

    // Constructeur
    public QuestionBO(int id, int num, String question, String reponse, int difficulte, String explication, String reference, String langue) {
        this.id = id;
        this.num = num;
        this.question = question;
        this.reponse = reponse;
        this.difficulte = difficulte;
        this.explication = explication;
        this.reference = reference;
        this.langue = langue;
    }

    // Getter et Setters
    public int getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public String getQuestion() {
        return question;
    }

    public String getReponse() {
        return reponse;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public String getExplication() {
        return explication;
    }

    public void setExplication(String explication) {
        this.explication = explication;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    // equals et hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionBO that = (QuestionBO) o;
        return id == that.id && num == that.num && difficulte == that.difficulte && Objects.equals(langue, that.langue) && Objects.equals(question, that.question) && Objects.equals(reponse, that.reponse) && Objects.equals(explication, that.explication) && Objects.equals(reference, that.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num, langue, question, reponse, difficulte, explication, reference);
    }
}
