/*
 * Classe Noeud                     08/10/2025
 * Représente un nœud d'arbre binaire.
 */
package genericite;

/**
 *
 * @param <T>
 */
public class Noeud<T> {

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
}