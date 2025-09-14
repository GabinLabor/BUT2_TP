/*
 *  gestion d'une pile d'entiers  avec exceptions prédéfinies
 *  PileEntier.java                                              09/22
 */
package structuredonnees;

/**
 * Cette classe représente une pile d'entiers.
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
 * @author INFO2
 * @version 1.0
 */
public class PileEntier {

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
     * Tableau contenant les entiers éléments de la pile
     */
    private int[] element;


    /**
     * Constructeur par défaut (pile vide avec la capacité par défaut)
     */
    public PileEntier() {

        // création d'une pile vide ayant la capacité par défaut
        taille = 0;             // à sa création, la pile est vide
        element = new int[CAPACITE_DEFAUT];
    }

    /**
     * Construit une pile vide avec la capacité argument
     *
     * @param capacite capacité de la pile à créer
     * @throws IllegalArgumentException levée si la capacité est invalide
     */
    public PileEntier(int capacite) throws IllegalArgumentException {

        // si la capacite argument est invalide, l'exception est levée
        if (capacite <= 0) {
            throw new IllegalArgumentException();
        }

        // sinon : création d'une pile vide avec la capacité argument
        taille = 0;
        element = new int[capacite];
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

    // suite  du TP
    /**
     * Empile une valeur au sommet de la pile
     * @param valeur valeur à empiler
     * @throws IllegalStateException levée si la pile est pleine
     */
    public void empiler(int valeur) throws IllegalStateException {
        if (estPleine()) {
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
    }

    /**
     * Retourne la valeur au sommet de la pile sans la retirer
     * @return la valeur au sommet de la pile
     * @throws IllegalStateException levée si la pile est vide
     */
    public int sommet() throws IllegalStateException {
        if (estVide()) {
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
    public static boolean memeCapacite(PileEntier p1, PileEntier p2) {
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

        StringBuilder sb = new StringBuilder("[ sommet = ");
        for (int i = taille - 1; i >= 0; i--) {
            sb.append(" ").append(element[i]).append(" |");
        }
        sb.append("  ]");
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
        if (!(obj instanceof PileEntier)) {
            return false;
        }

        PileEntier autre = (PileEntier) obj;

        // Les piles doivent avoir la même taille
        if (this.taille != autre.taille) {
            return false;
        }

        // Les éléments doivent être identiques dans le même ordre
        for (int i = 0; i < taille; i++) {
            if (this.element[i] != autre.element[i]) {
                return false;
            }
        }

        return true;
    }
}
