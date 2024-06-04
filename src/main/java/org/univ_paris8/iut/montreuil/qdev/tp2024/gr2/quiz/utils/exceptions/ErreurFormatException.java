package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions;

/* Les champs du fichier ne correspondent pas aux champs attendus */
public class ErreurFormatException extends Exception{
    public ErreurFormatException() {
        super("Les champs du fichier ne correspondent pas aux champs attendus.");
    }
}
