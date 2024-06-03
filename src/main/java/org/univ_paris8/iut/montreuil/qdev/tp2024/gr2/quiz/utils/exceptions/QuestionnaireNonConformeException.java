package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions;

/* Le contenu du questionnaire ne respecte pas les contraintes de validation métier
* ex: 2 questions identiques dans un même questionnaire
* */
public class QuestionnaireNonConformeException extends Exception{

    public QuestionnaireNonConformeException(String message) {
        super(message);
    }
}
