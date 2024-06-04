package org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.dto.QuestionnaireDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.entities.enums.*;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.impl.mocks.*;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.services.models.IServiceQuestionnaire;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr2.quiz.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceQuestionnaireimplTests {

    private IServiceQuestionnaire serviceQuestionnaireImpl;

    @BeforeEach
    void setUp(TestInfo testInfo) throws Exception {

        serviceQuestionnaireImpl = null;
        //serviceQuestionnaireImpl = new IServiceQuestionnaire();
        System.out.println("test " + testInfo.getDisplayName());
    }

    // Vérifier que la fonction renvoie bien un questionnaire.
    @Test
    void lireFichierQuestionnaireUniqueOKTest() {
        // MOCK à supprimer lors de l'ajout du vrai service
        serviceQuestionnaireImpl = new ServiceQuestionnaireUniqueMockOK();

        List<QuestionnaireDTO> questionnaireAttendu = new ArrayList<>();
        QuestionnaireDTO questionnaire = new QuestionnaireDTO(1);
        questionnaire.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE,"Question1?","Reponse1", LangueEnum.FRANCAIS));
        questionnaire.ajouterQuestion(new QuestionDTO(2,NiveauDifficulteQuestionEnum.INTERMEDIAIRE,"Question2?","Reponse2", LangueEnum.FRANCAIS));
        questionnaire.ajouterQuestion(new QuestionDTO(3,NiveauDifficulteQuestionEnum.EXPERT,"Question3?","Reponse3", LangueEnum.FRANCAIS));
        questionnaireAttendu.add(questionnaire);

        try {
            List<QuestionnaireDTO> questionnaireResultat = serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V1");
            assertEquals(questionnaireAttendu,questionnaireResultat,"Chargement d'un fichier avec un seul questionnaire");
        }
        catch (Exception e) {
            System.out.println("Erreur inattendu dans le test lireFichierQuestionnaireUniqueOKTest");
        }
    }

    // Vérifier que la fonction renvoie bien plusieurs questionnaires.
    @Test
    public void lireFichierDeuxQuestionnairesOKTest(){

        // Utiliser le bon mock
        serviceQuestionnaireImpl = new ServiceQuestionnaireDoubleMockOK();

        List<QuestionnaireDTO> questionnaireAttendu = new ArrayList<>();

        // Premier questionnaire
        QuestionnaireDTO questionnaire1 = new QuestionnaireDTO(1);
        questionnaire1.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE, "Question1?", "Reponse1", LangueEnum.FRANCAIS));
        questionnaire1.ajouterQuestion(new QuestionDTO(2, NiveauDifficulteQuestionEnum.INTERMEDIAIRE, "Question2?", "Reponse2", LangueEnum.FRANCAIS));
        questionnaire1.ajouterQuestion(new QuestionDTO(3, NiveauDifficulteQuestionEnum.EXPERT, "Question3?", "Reponse3", LangueEnum.FRANCAIS));

        // Deuxième questionnaire
        QuestionnaireDTO questionnaire2 = new QuestionnaireDTO(2);
        questionnaire2.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE, "Question4?", "Reponse1", LangueEnum.FRANCAIS));
        questionnaire2.ajouterQuestion(new QuestionDTO(2, NiveauDifficulteQuestionEnum.INTERMEDIAIRE, "Question5?", "Reponse2", LangueEnum.FRANCAIS));
        questionnaire2.ajouterQuestion(new QuestionDTO(3, NiveauDifficulteQuestionEnum.EXPERT, "Question6?", "Reponse3", LangueEnum.FRANCAIS));

        questionnaireAttendu.add(questionnaire1);
        questionnaireAttendu.add(questionnaire2);

        try {
            List<QuestionnaireDTO> questionnaireResultat = serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V2");
            assertEquals(questionnaireAttendu, questionnaireResultat, "Chargement d'un fichier avec deux questionnaires");
        } catch (Exception e) {
            System.out.println("Erreur inattendue dans le test lireFichierDeuxQuestionnairesOKTest");
            e.printStackTrace();
        }
    }

    // Vérifier qu'un questionnaire lance une exception s'il manque une question
    @Test
    public void champQuestionVideTest() {

        serviceQuestionnaireImpl = new ServiceQuestionnaireChampVideKO();

        assertThrows(ChampVideException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V3");
        }, "Chargement d'un fichier avec un champ question vide lance ChampVideException");
    }

    //Vérifier que la fonction renvoie une exception en cas de fichier d’un autre format.
    @Test
    public void formatTxtTest(){
        serviceQuestionnaireImpl = new ServiceQuestionnaireErreurParsingKO();

        assertThrows(ErreurParsingException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V4");
        }, "Chargement d'un fichier texte");

    }

    @Test
    public void fichierIntrouvableTest(){

        serviceQuestionnaireImpl = new ServiceQuestionnaireFichierIntrouvableKO();

        assertThrows(FichierIntrouvableException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V5");
        }, "Chargement d'un fichier inexistant");
    }

    @Test
    public void questionEnDoubleTest(){

        serviceQuestionnaireImpl = new ServiceQuestionnaireNonConformeKO();

        assertThrows(QuestionnaireNonConformeException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V6");
        }, "Chargement d'un questionnaire ayant deux fois la même question");
    }

    @Test
    public void fichierVideTest(){

        serviceQuestionnaireImpl = new ServiceQuestionnaireChampVideKO();

        assertThrows(ChampVideException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V7");
        }, "Le fichier est vide");
    }

    @Test
    public void fichierIdQuestionnaireStringTest(){

        serviceQuestionnaireImpl = new ServiceQuestionnaireErreurParsingKO();

        assertThrows(ErreurParsingException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V8");
        }, "Au moins une des données n'est pas du type attendu");
    }

    @Test
    public void colonnesSupplementairesTest(){

        serviceQuestionnaireImpl = new ServiceQuestionnaireErreurFormatKO();

        assertThrows(ErreurFormatException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V9");
        }, "le fichier contient des colonnes supplémentaires");
    }

    @Test
    public void langueNonReconnueTest(){

        serviceQuestionnaireImpl = new ServiceQuestionnaireErreurParsingKO();

        assertThrows(ErreurParsingException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V10");
        }, "le fichier contient un champ pour LangueEnum inconnu");
    }

    @Test
    public void delimiteurEspaceTest(){

        serviceQuestionnaireImpl = new ServiceQuestionnaireErreurParsingKO();

        assertThrows(ErreurParsingException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V11");
        }, "les champs du fichier ne sont pas correctement separes");
    }

    @Test
    public void plusieursLanguesTest(){

        serviceQuestionnaireImpl = new ServiceQuestionnaireNonConformeKO();

        assertThrows(QuestionnaireNonConformeException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V12");
        }, "un questionnaire ne peut pas contenir plusieurs langues");
    }

    @Test
    public void questionIdentiqueDeuxQuestionnairesTest(){
        // MOCK à supprimer lors de l'ajout du vrai service
        serviceQuestionnaireImpl = new ServiceQuestionnaireQuestionIdentiqueDifferentQuestionnaireOK();

        List<QuestionnaireDTO> questionnaireAttendu = new ArrayList<>();
        QuestionnaireDTO questionnaire = new QuestionnaireDTO(1);
        questionnaire.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE,"Question1?","Reponse1", LangueEnum.FRANCAIS));
        questionnaireAttendu.add(questionnaire);
        QuestionnaireDTO questionnaire2 = new QuestionnaireDTO(2);
        questionnaire2.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE,"Question1?","Reponse1", LangueEnum.FRANCAIS));
        questionnaireAttendu.add(questionnaire2);
        
        try {
            List<QuestionnaireDTO> questionnaireResultat = serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V13");
            assertEquals(questionnaireAttendu,questionnaireResultat,"Deux questionnaires ayant la même question");
        }
        catch (Exception e) {
            System.out.println("Erreur inattendu dans le test  questionIdentiqueDeuxQuestionnairesTest");
        }


    }

    @Test
    public void questionnairesIdentiquesTest(){
        serviceQuestionnaireImpl = new ServiceQuestionnaireNonConformeKO();

        assertThrows(QuestionnaireNonConformeException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V14");
        }, "le fichier contient plusieurs fois le même questionnaire");

    }

    @Test
    public void caracteresSpeciauxTest() {

        // MOCK à supprimer lors de l'ajout du vrai service
        serviceQuestionnaireImpl = new ServiceQuestionnaireCaracteresSpeciauxOK();

        List<QuestionnaireDTO> questionnaireAttendu = new ArrayList<>();
        QuestionnaireDTO questionnaire = new QuestionnaireDTO(1);
        questionnaire.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE, "Question&1?", "Réponse+&#1$", LangueEnum.FRANCAIS));
        questionnaireAttendu.add(questionnaire);

        try {
            List<QuestionnaireDTO> questionnaireResultat = serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V15");
            assertEquals(questionnaireAttendu, questionnaireResultat, "Questionnaire avec caractères spéciaux");
        } catch (Exception e) {
            System.out.println("Erreur inattendu dans le test  caracteresSpeciauxTest");
        }
    }

    @Test
    public void inverseQuestionReponseTest(){
        serviceQuestionnaireImpl = new ServiceQuestionnaireNonConformeKO();

        assertThrows(QuestionnaireNonConformeException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V16");
        }, "le fichier a les colonnes questions et reponses inversées");

    }

    @Test
    public void  reponseIncorrecteTest(){

        serviceQuestionnaireImpl = new ServiceQuestionnaireNonConformeKO();

        assertThrows(QuestionnaireNonConformeException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V17");
        }, "le fichier répond à une question par une question");

    }

    @Test
    public void memeQuestion2ReponseDifferenteTest(){

        serviceQuestionnaireImpl = new ServiceQuestionnaireNonConformeKO();

        assertThrows(QuestionnaireNonConformeException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V18");
        }, "le fichier a deux réponses différentes pour la même question");

    }

    @Test
    public void memeQuestion2ReponseDifferenteDifferentQuestionnaireTest(){

        serviceQuestionnaireImpl = new ServiceQuestionnaireNonConformeKO();

        assertThrows(QuestionnaireNonConformeException.class, () -> {
            serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V19");
        }, "deux questionnaires ont la même question mais deux réponses différentes");

    }

    @Test
    public void  differentesLanguesDifferentsQuestionnairesTest(){
        // Utiliser le bon mock
        serviceQuestionnaireImpl = new ServiceQuestionnairePlusieursLanguesOK();

        List<QuestionnaireDTO> questionnaireAttendu = new ArrayList<>();

        // Premier questionnaire
        QuestionnaireDTO questionnaire1 = new QuestionnaireDTO(1);
        questionnaire1.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE, "Question1?", "Reponse1", LangueEnum.FRANCAIS));
        questionnaireAttendu.add(questionnaire1);

        // Deuxième questionnaire
        QuestionnaireDTO questionnaire2 = new QuestionnaireDTO(2);
        questionnaire2.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE, "Question4?", "Reponse4", LangueEnum.ESPAGNOL));
        questionnaireAttendu.add(questionnaire2);

        // Troisième questionnaire
        QuestionnaireDTO questionnaire3 = new QuestionnaireDTO(3);
        questionnaire3.ajouterQuestion(new QuestionDTO(1, NiveauDifficulteQuestionEnum.SIMPLE, "Question5?", "Reponse5", LangueEnum.ITALIAN));
        questionnaireAttendu.add(questionnaire3);

        try {
            List<QuestionnaireDTO> questionnaireResultat = serviceQuestionnaireImpl.fournirListeQuestionnaires("questionsQuizz_V20");
            assertEquals(questionnaireAttendu, questionnaireResultat, "Chargement de plusieurs questionnaires de langues différentes");
        } catch (Exception e) {
            System.out.println("Erreur inattendue dans le test  differentesLanguesDifferentsQuestionnairesTest");
            e.printStackTrace();
        }
    }

    



    

    

    











}

    

    

    



