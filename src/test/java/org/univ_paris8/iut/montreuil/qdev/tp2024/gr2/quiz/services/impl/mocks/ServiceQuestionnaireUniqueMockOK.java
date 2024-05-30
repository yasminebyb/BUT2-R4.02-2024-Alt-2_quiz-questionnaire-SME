package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.NiveauDifficulteQuestion;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.ChampVideException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.ErreurFormatException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.ErreurLectureFichierExceptions;

import java.util.ArrayList;
import java.util.List;

public class ServiceQuestionnaireUniqueMockOK implements IServiceQuestionnaire {

    public ServiceQuestionnaireUniqueMockOK() {
    }

    @Override
    public List<QuestionnaireDTO> chargerQuestionnaires(String nomfichier) throws ErreurLectureFichierExceptions, ErreurFormatException, ChampVideException {

        List<QuestionnaireDTO> liste = new ArrayList<>();
        QuestionnaireDTO questionnaire = new QuestionnaireDTO(1);
        questionnaire.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestion.Simple,"Question1","Reponse1", LangueEnum.français));
        questionnaire.ajouterQuestion(new QuestionDTO(2,NiveauDifficulteQuestion.intermedaire,"Question2","Reponse2", LangueEnum.français));
        questionnaire.ajouterQuestion(new QuestionDTO(3,NiveauDifficulteQuestion.expert,"Question3","Reponse3", LangueEnum.français));
        liste.add(questionnaire);
        return liste;

    }

    

 
}
