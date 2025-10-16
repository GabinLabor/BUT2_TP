package genericite;

public class ArbreBinaire<T extends Comparable<T>> {

    private Noeud<T> racine;

    /** Constructeur : crée un arbre vide */
    public ArbreBinaire() {
        this.racine = null;
    }

    /** Indique si une valeur est présente dans l'arbre */
    public boolean estPresente(T valeurCherchee) {
        if (racine == null) {
            return false;
        } else {
            return racine.estPresente(valeurCherchee);
        }
    }
    /** Insère une valeur dans l'arbre */
    public boolean inserer(T aInserer) {
        if (racine == null) {
            racine = new Noeud<>(aInserer);
            return true;
        } else {
            return racine.inserer(aInserer);
        }
    }

    /** Affiche l’arbre hiérarchiquement */
    public void afficheArbreNiveau() {
        if (racine == null) {
            System.out.println("Arbre vide");
        } else {
            racine.afficheArbreNiveau(0);
        }
    }
}
