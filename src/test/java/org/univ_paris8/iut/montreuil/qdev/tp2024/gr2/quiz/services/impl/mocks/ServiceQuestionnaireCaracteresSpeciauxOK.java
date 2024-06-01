package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.NiveauDifficulteQuestionEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class ServiceQuestionnaireCaracteresSpeciauxOK implements IServiceQuestionnaire {
    public ServiceQuestionnaireCaracteresSpeciauxOK() {
    }

    @Override
    public List<QuestionnaireDTO> fournirListeQuestionnaires(String nomfichier) throws ChampVideException, ErreurFormatException, ErreurParsingException, FichierIntrouvableException, QuestionnaireNonConformeException {
        List<QuestionnaireDTO> liste = new ArrayList<>();

        // Premier questionnaire
        QuestionnaireDTO questionnaire = new QuestionnaireDTO(1);
        questionnaire.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE, "Question&1?", "Réponse+&#1$", LangueEnum.FRANCAIS));
        liste.add(questionnaire);
        
        return liste;
    }
}
