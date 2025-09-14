/* package heritage;

import java.util.Scanner;

 *
 * Classe Main pour démontrer le polymorphisme avec Individu et Personne
 *
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Démonstration du Polymorphisme ===\n");

        // Tableau polymorph qui peut contenir des Individu et des Personne
        // car personne hérite de Individu
        Individu[] tableau = new Individu[5];

        // remplissage du tableau
        for (int i = 0; i < tableau.length; i++) {
            System.out.println("--- Élément " + (i + 1) + " ---");
            System.out.print("Individu (I) ou Personne (P) ? ");
            String choix = scanner.nextLine().toUpperCase();

            if (choix.equals("I")) {
                tableau[i] = new Individu();
            } else {
                tableau[i] = new Personne();
            }

            tableau[i].saisir();
            System.out.println();
        }

        // Affichage du contenu
        System.out.println("=== Contenu du tableau ===\n");

        for (int i = 0; i < tableau.length; i++) {
            System.out.println("--- Élément " + (i + 1) + " ---");
            tableau[i].afficher(); // appel polymorphe
            System.out.println();
        }

        // Comptage des types
        int nbIndividus = 0;
        int nbPersonnes = 0;

        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i] instanceof Personne) {
                nbPersonnes++;
            } else {
                nbIndividus++;
            }
        }

        System.out.println("Résultats :");
        System.out.println("Individus : " + nbIndividus);
        System.out.println("Personnes : " + nbPersonnes);

        scanner.close();
    }
}

*/

package heritage;

import java.util.Scanner;

/**
 * Classe de test pour démontrer le polymorphisme avec Individu et Personne
 */
public class MainPolymorphisme {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Démonstration du Polymorphisme ===\n");

        // Déclaration d'un tableau de type Individu pouvant contenir
        // des instances d'Individu et de Personne (polymorphisme) car Personne hérite de Individu
        Individu[] tableau = new Individu[5];

        // Remplissage du tableau
        for (int i = 0; i < tableau.length; i++) {
            System.out.println("--- Élément " + (i + 1) + " du tableau ---");
            System.out.print("Voulez-vous créer un Individu (I) ou une Personne (P) ? ");
            String choix = scanner.nextLine().trim().toUpperCase();

            while (!choix.equals("I") && !choix.equals("P")) {
                System.out.print("Choix invalide. Tapez I pour Individu ou P pour Personne : ");
                choix = scanner.nextLine().trim().toUpperCase();
            }

            // on crée des instances dynamiques
            if (choix.equals("I")) {
                // Création d'une instance d'Individu
                System.out.println("Création d'un Individu");
                tableau[i] = new Individu();
                tableau[i].saisir();
            } else {
                // Création d'une instance de Personne
                System.out.println("Création d'une Personne");
                tableau[i] = new Personne();
                tableau[i].saisir(); // Appel polymorphe : méthode de Personne
            }

            System.out.println(); // ligne vide pour la lisibilité
        }

        // Affichage des éléments du tableau
        System.out.println("=== Affichage du contenu du tableau ===\n");

        for (int i = 0; i < tableau.length; i++) {
            System.out.println("--- Élément " + (i + 1) + " ---");

            // Polymorphisme en action car :
            // - Si tableau[i] contient un Individu -> méthode afficher() d'Individu
            // - Si tableau[i] contient une Personne -> méthode afficher() de Personne
            tableau[i].afficher();

            // Vérification du type réel pour information
            System.out.println("Type réel : " + tableau[i].getClass().getSimpleName());
            System.out.println();
        }

        // Démonstration supplémentaire du polymorphisme avec toString()
        System.out.println("=== Test avec toString() (polymorphisme) ===\n");

        for (int i = 0; i < tableau.length; i++) {
            // Appel polymorphe de toString()
            System.out.println("Élément " + (i + 1) + " : " + tableau[i].toString());
        }

        // Test avec instanceof pour illustrer la vérification de type
        System.out.println("\n=== Analyse des types avec instanceof ===\n");

        int nbIndividus = 0;
        int nbPersonnes = 0;

        for (int i = 0; i < tableau.length; i++) {
            if (tableau[i] instanceof Personne) {
                nbPersonnes++;
                System.out.println("Élément " + (i + 1) + " est une Personne");
            } else {
                nbIndividus++;
                System.out.println("Élément " + (i + 1) + " est un Individu");
            }
        }

        System.out.println("\nRésumé :");
        System.out.println("- Nombre d'Individus : " + nbIndividus);
        System.out.println("- Nombre de Personnes : " + nbPersonnes);
        System.out.println("- Total : " + (nbIndividus + nbPersonnes));

        scanner.close();
        System.out.println("\n=== Fin de la démonstration du polymorphisme ===");
    }
}
