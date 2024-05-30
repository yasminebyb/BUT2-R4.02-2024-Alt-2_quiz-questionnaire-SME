package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.NiveauDifficulteQuestion;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl.mocks.ServiceQuestionnaireUniqueMockOK;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models.IServiceQuestionnaire;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceQuestionnaireimplTests {

    private IServiceQuestionnaire serviceQuestionnaireImpl;

    @BeforeEach
    void setUp(TestInfo testInfo) throws Exception {

        serviceQuestionnaireImpl = null;

        System.out.println("test " + testInfo.getDisplayName());
    }

    @Test
    void lireFichierQuestionnaireUniqueOKTest() {
        // MOCK à supprimer lors de l'ajout du vrai service
        serviceQuestionnaireImpl = new ServiceQuestionnaireUniqueMockOK();


        List<QuestionnaireDTO> questionnaireAttendu = new ArrayList<>();
        QuestionnaireDTO questionnaire = new QuestionnaireDTO(1);
        questionnaire.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestion.Simple,"Question1","Reponse1", LangueEnum.français));
        questionnaire.ajouterQuestion(new QuestionDTO(2,NiveauDifficulteQuestion.intermedaire,"Question2","Reponse2", LangueEnum.français));
        questionnaire.ajouterQuestion(new QuestionDTO(3,NiveauDifficulteQuestion.expert,"Question3","Reponse3", LangueEnum.français));
        questionnaireAttendu.add(questionnaire);

        try {
            List<QuestionnaireDTO> questionnaireResultat = serviceQuestionnaireImpl.chargerQuestionnaires("questionsQuizz_V1");
            assertEquals(questionnaireAttendu,questionnaireResultat,"Chargement d'un fichier avec un seul questionnaire");
        }
        catch (Exception e) {
            System.out.println("Erreur inattendu dans le test lireFichierQuestionnaireUniqueOKTest");
        }
    }

    

}
