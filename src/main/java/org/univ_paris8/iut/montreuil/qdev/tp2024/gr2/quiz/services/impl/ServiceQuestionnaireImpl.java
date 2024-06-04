package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.bo.QuestionBO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.*;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.mappers.QuestionMapper.toQuestionDTO;

public class ServiceQuestionnaireImpl implements IServiceQuestionnaire {

    // CSV to QuestionBO
    public static List<QuestionBO> readCSV(String filePath) throws ChampVideException, ErreurFormatException, ErreurParsingException, FichierIntrouvableException, QuestionnaireNonConformeException {
        List<QuestionBO> questions = new ArrayList<>();
        Set<String> questionsSet = new HashSet<>();

        // Create a CSVParser with semicolon as the separator
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath)).withCSVParser(parser).build()) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length > 8) {
                    throw new ErreurFormatException();
                }
                try {
                    int id = Integer.parseInt(line[0]);
                    int num = Integer.parseInt(line[1]);
                    String langue = line[2];
                    String question = line[3];
                    String reponse = line[4];
                    int difficulte = Integer.parseInt(line[5]);
                    String explication = line[6];
                    String reference = line[7];

                    if (langue.isEmpty() || question.isEmpty() || reponse.isEmpty() || explication.isEmpty() || reference.isEmpty()) {
                        throw new ChampVideException();
                    }

                    if (questionsSet.contains(question)) {
                        throw new QuestionnaireNonConformeException();
                    }

                    QuestionBO questionBO = new QuestionBO(id, num, langue, question, reponse, difficulte, explication, reference);
                    questions.add(questionBO);
                    questionsSet.add(question);

                } catch (NumberFormatException e) {
                    throw new ErreurParsingException();
                }
            }

        } catch (FileNotFoundException e) {
            throw new FichierIntrouvableException();
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return questions;
    }

    public List <QuestionnaireDTO> fournirListeQuestionnaires (String nomfichier) throws ChampVideException, ErreurParsingException, QuestionnaireNonConformeException, FichierIntrouvableException, ErreurFormatException {
        // QuestionBO to QuestionDTO
        // creer une liste de questionnaire vide

        // parcours liste de questionBO
        // pour chaque questionBO
        // regarde le premier champs de la question BO
        // si numero questionnaire de la questionBO, si dans ma liste de questionnaireDTO il n'y a un questionnaire avce ce numéro --> le créer.
        // convertir la question BO en questionDTO
        // l'ajouter au questionnaire
        // retourne la liste de questionnaireDTO

        List <QuestionnaireDTO> questionnaireDTOS = new ArrayList<>();
        List <QuestionBO> questionBOS = readCSV(nomfichier);
        boolean trouvé = false;
        for (QuestionBO questionBo : questionBOS) {

            if (questionnaireDTOS.isEmpty()) {
                questionnaireDTOS.add(new QuestionnaireDTO(questionBo.getId()));
            }
            else{
                for (QuestionnaireDTO questionnaireDTO : questionnaireDTOS) {
                    if(questionnaireDTO.getIdQuestionnaire() == questionBo.getId()){
                        questionnaireDTO.ajouterQuestion(toQuestionDTO(questionBo));
                        trouvé = true;
                    }
                }

                if(!trouvé){
                    QuestionnaireDTO nouveauQuestionnaire = new QuestionnaireDTO(questionBo.getId());
                    nouveauQuestionnaire.ajouterQuestion(toQuestionDTO(questionBo));
                    questionnaireDTOS.add(nouveauQuestionnaire);
                }
            }

            trouvé = false;

        }

        return questionnaireDTOS;
    }

}
