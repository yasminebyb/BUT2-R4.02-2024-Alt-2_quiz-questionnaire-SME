package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl.mocks;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.*;

import java.util.List;

public class ServiceQuestionnaireFichierIntrouvableKO implements IServiceQuestionnaire {
    public ServiceQuestionnaireFichierIntrouvableKO() {
    }

    @Override
    public List<QuestionnaireDTO> fournirListeQuestionnaires(String nomfichier) throws ChampVideException, ErreurFormatException, ErreurParsingException, FichierIntrouvableException, QuestionnaireNonConformeException {
        throw new FichierIntrouvableException();
    }
}
