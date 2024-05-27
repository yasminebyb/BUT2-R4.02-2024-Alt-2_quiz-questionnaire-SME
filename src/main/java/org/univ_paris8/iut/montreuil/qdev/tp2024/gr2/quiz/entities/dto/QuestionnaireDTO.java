package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto;

import java.util.List;
import java.util.Objects;

public class QuestionnaireDTO {
    private int idQuestionnaire;
    private List<QuestionDTO> questions;

    // Constructeur
    public QuestionnaireDTO(int idQuestionnaire, List<QuestionDTO> questions) {
        this.idQuestionnaire = idQuestionnaire;
        this.questions = questions;
    }

    // Getters et Setters
    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    // equals et hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionnaireDTO that = (QuestionnaireDTO) o;
        return idQuestionnaire == that.idQuestionnaire && Objects.equals(questions, that.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestionnaire, questions);
    }
}