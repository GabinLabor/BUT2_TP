package structuredonnees.matrice;

import java.util.ArrayList;
import java.util.List;

/**
 * Représentation d’une matrice creuse :
 * - On ne stocke QUE les coefficients non nuls.
 * - Les coordonnées (l, c) et dimensions sont > 0
 */
public class MatriceCreuse {

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
    public MatriceCreuse() {
        this(NB_LIGNES_PAR_DEFAUT, NB_COLONNES_PAR_DEFAUT);
    }

    /**
     * Constructeur paramétré.
     * @param nbLignes   nombre de lignes (> 0)
     * @param nbColonnes nombre de colonnes (> 0)
     * @throws IllegalArgumentException si une dimension est invalide (avec message explicite)
     */
    public MatriceCreuse(int nbLignes, int nbColonnes) {
        if (nbLignes <= 0 || nbColonnes <= 0) {
            if (nbLignes <= 0 && nbColonnes <= 0) {
                System.out.println("lignes et colonnes invalides (" + nbLignes + ", " + nbColonnes + ")");
            } else if (nbLignes <= 0) {
                System.out.println("ligne invalide (" + nbLignes + ")");
            } else {
                System.out.println("colonne invalide (" + nbColonnes + ")");
            }
            throw new IllegalArgumentException(
                    "Erreur lors de l'appel au constructeur de MatriceCreuse : "
                            + ". Les dimensions doivent être strictement positives."
            );
        }

        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;

        // Au départ, la matrice est "toute à 0" => la liste est vide
        this.coefficients = new ArrayList<>();
    }
}