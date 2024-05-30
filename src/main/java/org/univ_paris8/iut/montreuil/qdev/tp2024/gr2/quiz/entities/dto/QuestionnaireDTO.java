package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionnaireDTO that = (QuestionnaireDTO) o;
        return idQuestionnaire == that.idQuestionnaire && questions.equals(that.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestionnaire, questions);
    }
}
