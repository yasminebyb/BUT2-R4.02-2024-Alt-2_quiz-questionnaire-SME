package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.bo.QuestionBO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                if (line.length != 8) {
                    throw new ErreurFormatException("Les champs du fichier ne correspondent pas aux champs attendus.");
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
                        throw new ChampVideException("Un des champs nécessaires pour créer le questionnaire est vide.");
                    }

                    if (questionsSet.contains(question)) {
                        throw new QuestionnaireNonConformeException("Deux questions identiques trouvées dans le questionnaire.");
                    }

                    QuestionBO questionBO = new QuestionBO(id, num, langue, question, reponse, difficulte, explication, reference);
                    questions.add(questionBO);
                    questionsSet.add(question);

                } catch (NumberFormatException e) {
                    throw new ErreurParsingException("Erreur lors de l'analyse du fichier, format non reconnu ou non supporté.");
                }
            }

        } catch (FileNotFoundException e) {
            throw new FichierIntrouvableException("Le fichier spécifié n'existe pas ou le fichier est incorrect.");
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return questions;
    }

    // QuestionBO to QuestionDTO
    // creer une liste de questionnaire vide

    // parcours liste de questionBO
    // pour chaque questionBO
    // regarde le premier champs de la question BO
    // si numero questionnaire de la questionBO,  si dans ma liste de questionnaireDTO il n'y a un questionnaire avce ce numéro --> le créer.
    // convertir la question BO en questionDTO
    // l'ajouter au questionnaire
    // retourne la liste de questionnaireDTO

}
