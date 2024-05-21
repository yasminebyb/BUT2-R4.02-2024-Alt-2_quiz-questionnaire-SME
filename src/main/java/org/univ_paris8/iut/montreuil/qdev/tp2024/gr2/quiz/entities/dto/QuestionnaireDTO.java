package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto;

import java.util.ArrayList;
import java.util.List;

public class QuestionnaireDTO {

    private int idQuestionnaire;
    private List<QuestionDTO> questions;


    public QuestionnaireDTO(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
        this.questions = new ArrayList<>();
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public void ajouterQuestion(QuestionDTO question){
        this.questions.add(question);
    }
}
