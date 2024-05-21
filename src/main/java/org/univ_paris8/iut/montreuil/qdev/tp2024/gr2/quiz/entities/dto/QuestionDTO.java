package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.NiveauDifficulteQuestion;

public class QuestionDTO {

    private int numero;
    private NiveauDifficulteQuestion difficulte;
    private String question;
    private String reponse;

    private LangueEnum langue;


    public QuestionDTO(int numero, NiveauDifficulteQuestion difficulte, String question, String reponse, LangueEnum langue) {
        this.numero = numero;
        this.difficulte = difficulte;
        this.question = question;
        this.reponse = reponse;
        this.langue = langue;
    }

    public int getNumero() {
        return numero;
    }
    public NiveauDifficulteQuestion getDifficulte() {
        return difficulte;
    }

    public String getQuestion() {
        return question;
    }

    public String getReponse() {
        return reponse;
    }

    public LangueEnum getLangue() {
        return langue;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDifficulte(NiveauDifficulteQuestion difficulte) {
        this.difficulte = difficulte;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public void setLangue(LangueEnum langue) {
        this.langue = langue;
    }
}
