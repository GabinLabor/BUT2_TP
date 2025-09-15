package structuredonnees.matrice;

import java.util.ArrayList;
import java.util.List;

/**
 * Représentation d’une matrice creuse :
 * - On ne stocke que les coefficients non nuls.
 * - Les coordonnées (l, c) et dimensions sont > 0
 */
public class Matrice {

    /**
     * Nombre de lignes de la matrice (>= 1).
     */
    private int nbLignes;
    /**
     * Nbr de colonnes de la matrice (>= 1).
     */
    private int nbColonnes;

    private static final int NB_LIGNES_PAR_DEFAUT = 5;
    private static final int NB_COLONNES_PAR_DEFAUT = 5;
    /**
     * Liste des coefficients non nuls. Par convention,
     * chaque élément représente un triplet (ligne, colonne, valeur).
     */
    private List<Coefficient> coefficients;

    /**
     * Constructeur par défaut : crée une matrice 5x5 toute à 0.
     */
    public Matrice() {
        this(NB_LIGNES_PAR_DEFAUT, NB_COLONNES_PAR_DEFAUT);
    }

    /**
     * Constructeur avec dimensions.
     * @param nbLignes    nombre de lignes (>= 1)
     * @param nbColonnes  nombre de colonnes (>= 1)
     * @throws IllegalArgumentException si une dimension est < 1
     */
    public Matrice(int nbLignes, int nbColonnes) {
        if (nbLignes < 1 || nbColonnes < 1) {
            throw new IllegalArgumentException(
                    "Constructeur : dimensions invalides (" + nbLignes + " x " + nbColonnes
                            + "). Les deux doivent être >= 1.");
        }
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        // au départ tous les coefficients sont nuls donc > liste vide
        this.coefficients = new ArrayList<>();
    }

    // petits accesseurs utiles pour apres
    public int getNbLignes()   { return nbLignes; }
    public int getNbColonnes() { return nbColonnes; }

    // arrivé ici les tests ne passaient pas j'ai du changé les noms de la classe et ses méthodes
    // pour me conformer aux tests MatriceCreuse > Matrice

    /** Modifie la valeur en (ligne, colonne). Ne stocke pas de 0. */
    public void setValeur(int ligne, int colonne, double valeur) {
        if (valeur == 0) { // suppression si présent
            supprimer(ligne, colonne); // TODO méthode suppr
        }
    }
}