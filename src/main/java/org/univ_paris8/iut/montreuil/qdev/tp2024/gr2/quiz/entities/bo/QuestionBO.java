package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.bo;

public class QuestionBO {

    private int id;
    private int num;
    private String langue;
    private String question;
    private String reponse;


    private int difficulte;
    private String explication;
    private String reference;


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
}
