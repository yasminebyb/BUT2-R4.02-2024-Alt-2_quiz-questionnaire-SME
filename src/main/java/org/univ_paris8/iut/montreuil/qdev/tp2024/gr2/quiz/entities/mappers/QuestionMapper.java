package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.mappers;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.bo.QuestionBO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.LangueEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.NiveauDifficulteQuestionEnum;

public class QuestionMapper {

    public static QuestionDTO toQuestionDTO(QuestionBO questionBO) {
        if (questionBO == null) {
            return null;
        }

        LangueEnum langueEnum = mapLangue(questionBO.getLangue());
        NiveauDifficulteQuestionEnum difficulteEnum = mapDifficulte(questionBO.getDifficulte());

        return new QuestionDTO(
                questionBO.getNum(),
                difficulteEnum,
                questionBO.getQuestion(),
                questionBO.getReponse(),
                langueEnum
        );
    }

    private static LangueEnum mapLangue(String langue) {
        for (LangueEnum langueEnum : LangueEnum.values()) {
            if (langueEnum.getCode().equalsIgnoreCase(langue)) {
                return langueEnum;
            }
        }
        throw new IllegalArgumentException("Langue non reconnue: " + langue);
    }

    private static NiveauDifficulteQuestionEnum mapDifficulte(int difficulte) {
        for (NiveauDifficulteQuestionEnum difficulteEnum : NiveauDifficulteQuestionEnum.values()) {
            if (difficulteEnum.getLevel() == difficulte) {
                return difficulteEnum;
            }
        }
        throw new IllegalArgumentException("Niveau de difficulté non reconnu: " + difficulte);
    }

    public static String getLangueCode(LangueEnum langueEnum) {
        return langueEnum.getCode();
    }

    public static int getDifficulteLevel(NiveauDifficulteQuestionEnum difficulteEnum) {
        return difficulteEnum.getLevel();
    }
}