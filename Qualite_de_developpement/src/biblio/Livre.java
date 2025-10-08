/**
 * DOCUMENTATION DU FICHIER : "Livre.java"
 */
package biblio;

/**
 * DOCUMENTATION DE LA CLASSE
 *
 * Getsion des informations d'un livre
 *
 * @author Gabin Laborieux
 * @version 1.0
 * @since 08-10-2025
 */
public class Livre {

    /**
     * Titre du livre
     */
    private String titre;

    /**
     * Auteur du livre
     */
    private String auteur;

    /**
     * DOI du livre
     */
    private String doi;

    /**
     * Constructeur d'un livre
     *
     * @param titre
     * @param auteur
     * @param doi
     */
    public Livre(String titre, String auteur, String doi) {
        super();
        this.titre = titre;
        this.auteur = auteur;
        this.doi = doi;
    }

    getter

    setter
}
