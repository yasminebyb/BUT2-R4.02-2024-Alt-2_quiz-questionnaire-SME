package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions;

/*Le fichier spécifié n'existe pas ou le fichier est incorrecte*/

public class FichierIntrouvableException extends Exception{

    public FichierIntrouvableException() {
        super("Le fichier spécifié n'existe pas ou le fichier est incorrect.");
        //"Le fichier spécifié n'existe pas ou le fichier est incorrect"
    }

}
