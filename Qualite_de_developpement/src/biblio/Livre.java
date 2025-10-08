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

    /**
     * Obtenir le titre du livre
     * @return le titre du livre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définir le titre du livre
     * @return titre le titre à définir
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Obtenir l'auteur du livre
     * @return l'auteur du livre
     */
    public String getAuteur() {
        return titre;
    }

    /**
     * Définir le titre du livre
     * @return titre le titre à définir
     */
    public void setAuteur(String  auteur) {
        this.auteur = auteur;
    }

    /**
     * Obtenir le DOI du livre
     * @return le DOI du livre
     */
    public String getDoi() {
        return titre;
    }

    /**
     * Définir le titre du livre
     * @return titre le titre à définir
     */
    public void setDoi(String Doi) {
        this.doi = Doi;
    }

    // TODO voir dans Intellij comment générer documentation, javadoc et les constructeurs getters setters
}
