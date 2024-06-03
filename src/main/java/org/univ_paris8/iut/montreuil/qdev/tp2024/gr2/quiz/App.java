package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.bo.QuestionBO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.mappers.QuestionMapper;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl.ServiceQuestionnaireImpl;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.*;

import java.net.URL;
import java.util.List;

import static org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl.ServiceQuestionnaireImpl.readCSV;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        QuestionBO questionBO = new QuestionBO(1, 10, "fr","Quelle est la capitale de la France?", "Paris", 1, "Paris est la capitale et la plus grande ville de France.", "Wikipedia");
        QuestionDTO questionDTO = QuestionMapper.toQuestionDTO(questionBO);

        String langueCode = QuestionMapper.getLangueCode(questionDTO.getLangue());
        int difficulteLevel = QuestionMapper.getDifficulteLevel(questionDTO.getDifficulte());

        System.out.println("Question DTO:");
        System.out.println("Numéro: " + questionDTO.getNumeroQuestion());
        System.out.println("Difficulté: " + difficulteLevel);
        System.out.println("Libellé: " + questionDTO.getLibelle());
        System.out.println("Réponse: " + questionDTO.getReponse());
        System.out.println("Langue: " + langueCode);


        System.out.println("test lecture csv : ");
        try {
            // Utiliser getResource pour obtenir le chemin du fichier dans les ressources
            URL resource = ServiceQuestionnaireImpl.class.getClassLoader().getResource("questionsQuizz_V1_test.csv");
            if (resource == null) {
                throw new FichierIntrouvableException("Le fichier spécifié n'existe pas dans les ressources.");
            }

            String filePath = resource.getPath();
            List<QuestionBO> questions = readCSV(filePath);
            for (QuestionBO question : questions) {
                // Afficher ou traiter chaque question
                System.out.println(question);
            }
        } catch (ChampVideException | ErreurFormatException | ErreurParsingException | FichierIntrouvableException | QuestionnaireNonConformeException e) {
            System.out.println(e.getMessage());
        }

    }
}
