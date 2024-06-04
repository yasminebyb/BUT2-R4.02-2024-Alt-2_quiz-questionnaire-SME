package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.NiveauDifficulteQuestionEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class ServiceQuestionnairePlusieursLanguesOK implements IServiceQuestionnaire {
    public ServiceQuestionnairePlusieursLanguesOK() {
    }

    @Override
    public List<QuestionnaireDTO> fournirListeQuestionnaires(String nomfichier) throws ChampVideException, ErreurFormatException, ErreurParsingException, FichierIntrouvableException, QuestionnaireNonConformeException {
        List<QuestionnaireDTO> liste = new ArrayList<>();

        // Premier questionnaire
        QuestionnaireDTO questionnaire1 = new QuestionnaireDTO(1);
        questionnaire1.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE, "Question1?", "Reponse1", LangueEnum.FRANCAIS));
        liste.add(questionnaire1);

        // Deuxième questionnaire
        QuestionnaireDTO questionnaire2 = new QuestionnaireDTO(2);
        questionnaire2.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE, "Question4?", "Reponse4", LangueEnum.ESPAGNOL));
        liste.add(questionnaire2);

        // Troisième questionnaire
        QuestionnaireDTO questionnaire3 = new QuestionnaireDTO(3);
        questionnaire3.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE, "Question5?", "Reponse5", LangueEnum.ITALIAN));
        liste.add(questionnaire3);

        return liste;
    }
}
