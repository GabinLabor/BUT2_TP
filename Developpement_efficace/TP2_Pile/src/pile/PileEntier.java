package pile;

/**
 * Classe représentant une pile d'entiers avec une capacité fixée à la création
 * @author INFO2
 * @version 1.0
 */
public class PileEntier {

    /** Capacité par défaut de la pile */
    private static final int CAPACITE_DEFAUT = 10;

    /** Tableau contenant les éléments de la pile */
    private int[] elements;

    /** Capacité maximale de la pile */
    private final int capacite;

    private int sommetIndex;

    /**
     * Constructeur par défaut
     * Crée une pile vide avec la capacité par défaut (10)
     */
    public PileEntier() {
        this(CAPACITE_DEFAUT);
    }

















    /**
     * Constructeur avec capacité spécifiée
     * @param capacite capacité maximale de la pile
     * @throws IllegalArgumentException si la capacité est négative ou nulle
     */
    public PileEntier(int capacite) {
        if (capacite <= 0) {
            throw new IllegalArgumentException("La capacité doit être positive");
        }
        this.capacite = capacite;
        this.elements = new int[capacite];
        this.sommetIndex = -1; // pile vide
    }

    /**
     * Détermine si la pile est vide
     * @return true si la pile est vide, false sinon
     */
    public boolean estVide() {
        return sommetIndex == -1;
    }

    /**
     * Détermine si la pile est pleine
     * @return true si la pile est pleine, false sinon
     */
    public boolean estPleine() {
        return sommetIndex == capacite - 1;
    }

    /**
     * Empile un entier au sommet de la pile
     * @param element l'entier à empiler
     * @throws IllegalStateException si la pile est pleine
     */
    public void empiler(int element) {
        if (estPleine()) {
            throw new IllegalStateException("Impossible d'empiler : pile pleine");
        }
        elements[++sommetIndex] = element;
    }

    /**
     * Retourne la valeur du sommet de la pile sans la dépiler
     * @return la valeur au sommet de la pile
     * @throws IllegalStateException si la pile est vide
     */
    public int sommet() {
        if (estVide()) {
            throw new IllegalStateException("Impossible de consulter le sommet : pile vide");
        }
        return elements[sommetIndex];
    }

    /**
     * Dépile l'élément au sommet de la pile
     * @throws IllegalStateException si la pile est vide
     */
    public void depiler() {
        if (estVide()) {
            throw new IllegalStateException("Impossible de dépiler : pile vide");
        }
        sommetIndex--;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de la pile
     * @return une chaîne représentant le contenu de la pile
     */
    @Override
    public String toString() {
        if (estVide()) {
            return "[  ]";
        }

        StringBuilder sb = new StringBuilder("[ sommet = ");
        sb.append(String.format("%2d", elements[sommetIndex]));

        // Parcourir du sommet vers le bas
        for (int i = sommetIndex - 1; i >= 0; i--) {
            sb.append(" | ").append(elements[i]);
        }

        sb.append(" |  ]");
        return sb.toString();
    }

    /**
     * Détermine si deux piles ont la même capacité
     * @param pile1 première pile
     * @param pile2 deuxième pile
     * @return true si les deux piles ont la même capacité, false sinon
     */
    public static boolean memeCapacite(PileEntier pile1, PileEntier pile2) {
        return pile1.capacite == pile2.capacite;
    }

    /**
     * Détermine si deux piles sont identiques (même capacité et même contenu)
     * @param obj l'objet à comparer avec cette pile
     * @return true si les piles sont identiques, false sinon
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

        // Vérifier la capacité
        if (this.capacite != autre.capacite) {
            return false;
        }

        // Vérifier la taille (nombre d'éléments)
        if (this.sommetIndex != autre.sommetIndex) {
            return false;
        }

        // Vérifier le contenu
        for (int i = 0; i <= sommetIndex; i++) {
            if (this.elements[i] != autre.elements[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Accesseur pour la capacité (pour les tests)
     * @return la capacité de la pile
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * Accesseur pour la taille actuelle (pour les tests)
     * @return le nombre d'éléments dans la pile
     */
    public int getTaille() {
        return sommetIndex + 1;
    }
}