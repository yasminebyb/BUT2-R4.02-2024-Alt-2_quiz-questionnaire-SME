package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.*;

import java.util.List;

public interface IServiceQuestionnaire {

    public default List<QuestionnaireDTO> fournirListeQuestionnaires (String nomfichier) throws ChampVideException, ErreurFormatException, ErreurParsingException, FichierIntrouvableException, QuestionnaireNonConformeException {
        return null;
    }
}
