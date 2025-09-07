package heritage;

import java.util.Scanner;

/**
 * Classe qui représente une personne avec ses informations complètes :
 * nom, prénom (hérités d'Individu), téléphone et adresse électronique
 * 
 * @author INFO2
 * @version 1.0
 */
public class Personne extends Individu {

    /** Scanner pour saisies */
    private static Scanner entree = new Scanner(System.in);

    /** email par défaut */
    private static final String MAIL_DEFAUT = "inconnu@inconnu.com";

    /** Numéro de tel de la personne */
    private Telephone numeroTel;

    /** Adresse mail de la personne */
    private String adresseEmail;

    /**
     * Constructeur par défaut
     * Initialise tous les attributs avec des valeurs par défaut
     */
    public Personne() {
        super(); // afin d'appeller le constructeur d'Individu qui est la super classe
        numeroTel = new Telephone();
        adresseEmail = MAIL_DEFAUT;
    }

    public Personne(leNom : String, lePrenom : String) {
        super(leNom, lePrenom);
        numeroTel = new Telephone();
        adresseEmail = MAIL_DEFAUT;
    }

}



    

