package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.NiveauDifficulteQuestionEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class ServiceQuestionnaireDoubleMockOK implements IServiceQuestionnaire {
    public ServiceQuestionnaireDoubleMockOK() {
    }

    @Override
    public List<QuestionnaireDTO> fournirListeQuestionnaires(String nomfichier) throws ChampVideException, ErreurFormatException, ErreurParsingException, FichierIntrouvableException, QuestionnaireNonConformeException {
        List<QuestionnaireDTO> liste = new ArrayList<>();

        // Premier questionnaire
        QuestionnaireDTO questionnaire1 = new QuestionnaireDTO(1);
        questionnaire1.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE, "Question1?", "Reponse1", LangueEnum.FRANCAIS));
        questionnaire1.ajouterQuestion(new QuestionDTO(2, NiveauDifficulteQuestionEnum.INTERMEDIAIRE, "Question2?", "Reponse2", LangueEnum.FRANCAIS));
        questionnaire1.ajouterQuestion(new QuestionDTO(3, NiveauDifficulteQuestionEnum.EXPERT, "Question3?", "Reponse3", LangueEnum.FRANCAIS));
        liste.add(questionnaire1);

        // Deuxième questionnaire
        QuestionnaireDTO questionnaire2 = new QuestionnaireDTO(2);
        questionnaire2.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE, "Question4?", "Reponse1", LangueEnum.FRANCAIS));
        questionnaire2.ajouterQuestion(new QuestionDTO(2, NiveauDifficulteQuestionEnum.INTERMEDIAIRE, "Question5?", "Reponse2", LangueEnum.FRANCAIS));
        questionnaire2.ajouterQuestion(new QuestionDTO(3, NiveauDifficulteQuestionEnum.EXPERT, "Question6?", "Reponse3", LangueEnum.FRANCAIS));
        liste.add(questionnaire2);

        return liste;
    }
}
