/*
 * Gestion d'une pile générique avec exceptions prédéfinies
 * Pile.java                                                    09/22
 */
package structuredonnees;

/**
 * Cette classe représente une pile générique d'éléments de type T.
 * Les opérations possibles sont
 *      création de la pile,
 *      tester si la pile est vide ou pleine,
 *      empiler une valeur,
 *      dépiler,
 *      consulter la valeur du sommet,
 *      renvoyer le contenu de la pile sous-la forme d'une chaîne de caractères,
 *      déterminer si 2 piles ont la même capacité,
 *      déterminer si 2 piles sont égales
 * Les méthodes qui ne peuvent pas être exécutées normalement provoquent
 * la levée d'une exception : IllegalArgumentException et IllegalStateException
 * @param <T> type des éléments contenus dans la pile
 * @author INFO2
 * @version 1.0
 */
public class Pile<T> {

    /**
     * Valeur par défaut pour la capacité de la pile
     */
    private static final int CAPACITE_DEFAUT = 10;

    /**
     * Taille de la pile (ou nombre d'éléments qu'elle contient)
     * Le sommet de la pile se trouve donc à l'indice taille-1
     */
    private int taille;

    /**
     * Tableau contenant les éléments de la pile
     */
    private T[] element; // tableau générique

    /**
     * Constructeur par défaut (pile vide avec la capacité par défaut)
     */
    public Pile() {
        // création d'une pile vide ayant la capacité par défaut
        taille = 0;             // à sa création, la pile est vide
        element = (T[]) new Object[CAPACITE_DEFAUT]; // cast nécessaire car new T[] impossible
    }

    /**
     * Construit une pile vide avec la capacité argument
     *
     * @param capacite capacité de la pile à créer
     * @throws IllegalArgumentException levée si la capacité est invalide
     */
    public Pile(int capacite) throws IllegalArgumentException {
        // si la capacite argument est invalide, l'exception est levée
        if (capacite <= 0) {
            throw new IllegalArgumentException();
        }

        // sinon : création d'une pile vide avec la capacité argument
        taille = 0;
        element = (T[]) new Object[capacite];
    }

    /**
     * Détermine si la pile est pleine
     *
     * @return un booléen égal à vrai ssi la pile est pleine
     */
    public boolean estPleine() {
        return taille == element.length;
    }

    /**
     * Détermine si la pile est vide
     *
     * @return un booléen égal à vrai ssi la pile est vide
     */
    public boolean estVide() {
        return taille == 0;
    }

    /**
     * Empile une valeur au sommet de la pile
     * @param valeur valeur à empiler
     * @throws IllegalStateException levée si la pile est pleine
     */
    public void empiler(T valeur) throws IllegalStateException {
        if (estPleine()) { // Le paramètre est maintenant de type `T`
            throw new IllegalStateException();
        }
        element[taille] = valeur;
        taille++;
    }

    /**
     * Dépile l'élément au sommet de la pile
     * @throws IllegalStateException levée si la pile est vide
     */
    public void depiler() throws IllegalStateException {
        if (estVide()) {
            throw new IllegalStateException();
        }
        taille--;
        // Optionnel : supprimer la référence pour éviter les fuites mémoire
        element[taille] = null;
    }

    /**
     * Retourne la valeur au sommet de la pile sans la retirer
     * @return la valeur au sommet de la pile
     * @throws IllegalStateException levée si la pile est vide
     */
    public T sommet() throws IllegalStateException {
        if (estVide()) { // Retourne maintenant un `T` au lieu d'un `int`
            throw new IllegalStateException();
        }
        return element[taille - 1];
    }

    /**
     * Détermine si deux piles ont la même capacité
     * @param p1 première pile à comparer
     * @param p2 deuxième pile à comparer
     * @return un booléen égal à vrai ssi les deux piles ont la même capacité
     */
    public static boolean memeCapacite(Pile<?> p1, Pile<?> p2) {
        // Utilise des wildcards `?` pour accepter toute pile générique
        return p1.element.length == p2.element.length;
    }

    /**
     * Retourne une représentation sous forme de chaîne de la pile
     * @return une chaîne représentant le contenu de la pile
     */
    @Override
    public String toString() {
        if (estVide()) {
            return "[  ]";
        }

        StringBuilder sb = new StringBuilder("[ sommet =");
        for (int i = taille - 1; i >= 0; i--) {
            sb.append(" ").append(element[i]).append(" |");
        }
        sb.append(" ]");
        return sb.toString();
    }

    /**
     * Teste l'égalité entre deux piles
     * @param obj objet à comparer avec cette pile
     * @return un booléen égal à vrai ssi les deux piles sont égales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pile<?>)) {
            return false;
        }

        Pile<?> autre = (Pile<?>) obj;

        // Les piles doivent avoir la même capacité et la même taille
        if (this.element.length != autre.element.length || this.taille != autre.taille) {
            return false;
        }

        // Les éléments doivent être identiques dans le même ordre
        for (int i = 0; i < taille; i++) {
            // Utilisation de Objects.equals pour gérer les valeurs null
            // Plus d'opérateur == pour comparer les éléments
            if (!java.util.Objects.equals(this.element[i], autre.element[i])) {
                return false;
            }
        }
        /*
            Pourquoi objects.equals() ?
            > Gère les valeurs `null` correctement
            > Utilise automatiquement la méthode `equals()` des objets
            > Fonctionne avec tous les types (String, Telephone, etc.)
         */
        return true;
    }

    /**
     * Redéfinition de hashCode pour être cohérent avec equals
     * @return code de hachage de la pile
     */
    @Override
    public int hashCode() {
        // quand on redéfinit `equals()`, il faut aussi redéfinir `hashCode()`.
        int result = taille;
        result = 31 * result + element.length;
        for (int i = 0; i < taille; i++) {
            result = 31 * result + (element[i] != null ? element[i].hashCode() : 0);
        }
        return result;
    }
}