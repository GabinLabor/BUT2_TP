/*
 * Classe Noeud                     08/10/2025
 * Représente un nœud d'arbre binaire.
 */
package genericite;

/**
 *
 * @param <T>
 */
public class Noeud<T extends Comparable<T>> {

    private final T valeur;
    private Noeud<T> gauche; // attribut du même type que la classe
    private Noeud<T> droit;  // donc structure récursive, pour définir attribut on a besoin de la classe noeud

    /**
     * Crée un nœud contenant la valeur donnée, sans descendants.
     *
     * @param valeur valeur du nœud (non null recommandé)
     */
    public Noeud(T valeur) {
        this.valeur = valeur;
        this.gauche = null;
        this.droit = null;
    }

    /**
     * Indique si la valeur cherchée est présente dans l'arbre débutant au nœud courant.
     * @param valeurCherchee valeur recherchée
     * @return true si présente, false sinon
     */
    public boolean estPresente(T valeurCherchee) {
        int cmp = valeurCherchee.compareTo(this.valeur);
        // être plus strict,en appliquant le type T. Donc ici type doit implémenté la classe comparable

        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return (gauche != null) && gauche.estPresente(valeurCherchee);
        } else {
            return (droit !=null) && droit.estPresente(valeurCherchee);
        }
    }

    /**
     *
     * @param aInserer valeur à insérer
     * @return true si l'insertion a été effectuée, false si la valeur existait déjà
     */
    public boolean inserer(T aInserer) {
        int cmp = aInserer.compareTo(this.valeur);
        if (cmp == 0) {
            return false; // Pas de doublons
        } else if (cmp < 0) {
            if (gauche == null) {
                gauche = new Noeud<>(aInserer);
                return true;
            }

}