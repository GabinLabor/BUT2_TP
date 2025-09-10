
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
    private static final Scanner entree = new Scanner(System.in);

    /** email par défaut */
    private static final String MAIL_DEFAUT = "inconnu@inconnu.com";

    /** Numéro de tel de la personne */
    private final Telephone numeroTel;

    /** Adresse mail de la personne */
    private String adresseEmail;

    /**
     * Constructeur par défaut
     * Initialise tous les attributs avec des valeurs par défaut
     */
    public Personne() {
        super();
        numeroTel = new Telephone();
        adresseEmail = MAIL_DEFAUT;
    }

    /**
     * Constructeur avec nom et prénom
     * Les autres informations sont initialisées par défaut
     * @param leNom le nom de la personne
     * @param lePrenom le prénom de la personne
     */
    public Personne(String leNom, String lePrenom) {
        super(leNom, lePrenom);
        numeroTel = new Telephone();
        adresseEmail = MAIL_DEFAUT;
    }

    /**
     * Constructeur avec toutes les informations
     * @param leNom le nom de la personne
     * @param lePrenom le prénom de la personne
     * @param leTelephone le numéro de téléphone (chaîne de caractères)
     * @param leMail l'adresse électronique
     */
    public Personne(String leNom, String lePrenom, String leTelephone, String leMail) {
        super(leNom, lePrenom);
        numeroTel = new Telephone(leTelephone);
        // Si l'email n'est pas valide, utiliser l'email par défaut
        if (leMail == null || leMail.trim().isEmpty() || !emailValide(leMail.trim())) {
            adresseEmail = MAIL_DEFAUT;
        } else {
            adresseEmail = leMail.trim();
        }
    }

    /**
     * Vérifie si une adresse électronique est valide
     * Format attendu : [lettres/chiffres/-/_/.]@[lettres/chiffres/-/_].[2-3 lettres]
     * @param email l'adresse à vérifier
     * @return true si l'adresse est valide, false sinon
     */
    private boolean emailValide(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Regex pour valider le format email selon les critères demandés
        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9_-]+\\.[a-zA-Z]{2,3}$";
        return email.matches(regex);
    }

    /**
     * Affiche les informations connues sur la personne
     */
    public void afficher() {
        super.afficher(); // affiche nom et prénom
        System.out.print("Telephone ..... : ");
        numeroTel.afficher();
        System.out.println();
        System.out.println("Email ......... : " + adresseEmail);
    }

    /**
     * Saisit au clavier les 4 informations décrivant une personne
     */
    public void saisir() {
        super.saisir(); // saisie nom et prénom
        numeroTel.saisir(); // saisie téléphone

        // saisie de l'email avec validation
        boolean emailCorrect = false;
        do {
            System.out.print("Email ....... ? ");
            String emailSaisi = entree.nextLine().trim();

            if (emailSaisi.isEmpty()) {
                adresseEmail = MAIL_DEFAUT;
                emailCorrect = true;
            } else if (emailValide(emailSaisi)) {
                adresseEmail = emailSaisi;
                emailCorrect = true;
            } else {
                System.out.println("Adresse email invalide. Recommencez !");
            }
        } while (!emailCorrect);
    }

    /**
     * Renvoie toutes les informations connues sur la personne
     * sous forme d'une chaîne de caractères formatée
     * @return une chaîne contenant nom, prénom, téléphone et email
     */
    public String information() {
        return super.toString() + "\n" + numeroTel.getNumero() + "\n" + adresseEmail;
    }
}