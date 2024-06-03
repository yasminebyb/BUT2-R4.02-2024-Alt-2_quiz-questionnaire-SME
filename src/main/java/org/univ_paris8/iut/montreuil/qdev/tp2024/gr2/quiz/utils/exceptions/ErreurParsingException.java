package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions;

/* Erreur lors de l'analyse du fichier, format non reconnu ou non supporté
* ex : délimiteur manquant
* */
public class ErreurParsingException extends Exception {
    public ErreurParsingException(String message) {
        super(message);
    }
}
