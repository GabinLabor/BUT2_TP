/*
 * TP CLASSE PILE - PROGRAMME DE TEST
 * ----------------------------------
 *
 * tests de la classe Pile
 * TestPileEntierComplet.java                                                09/22
 */
package structuredonnees;

/**
 * Tests de base pour la classe Pile.
 * Les tests portent sur les différentes méthodes de la classe Pile,
 * ainsi que sur les exceptions susceptibles d'être levées par les
 * méthodes.
 * @author INFO2
 * @version 1.0
 */
public class TestPileEntierComplet {

    /**
     * Test simple selon les étapes du sujet (Questions 2 et 3)
     */
    private static void testSimpleDuSujet() {
        System.out.println("=== TESTS SIMPLES DU SUJET ===\n");
        testSimpleEtapes();
        System.out.println("=== FIN TESTS SIMPLES ===\n");
    }

        /**
         * Test simple selon les 11 étapes de la question 2 du TP
         */
        private static void testSimpleEtapes() {
            try {
                // Étapes 1-2 : Créer pile de capacité 5 et vérifier qu'elle est vide
                PileEntier pile = new PileEntier(5);
                System.out.println("1-2. Pile créée, est vide : " + pile.estVide());

                // Étapes 3-4 : Empiler 3 entiers et vérifier que pile n'est pas vide
                pile.empiler(10);
                pile.empiler(20);
                pile.empiler(30);
                System.out.println("3-4. Après empilage, est vide : " + pile.estVide());

                // Étape 5 : Afficher valeur au sommet
                System.out.println("5. Valeur au sommet : " + pile.sommet());

                // Étape 6 : Afficher contenu
                System.out.println("6. Contenu : " + pile);

                // Étape 7-8 : Dépiler et afficher
                pile.depiler();
                System.out.println("7-8. Après dépilage : " + pile);

                // Étape 9-10 : Empiler 3 entiers et vérifier si pleine
                pile.empiler(40);
                pile.empiler(50);
                pile.empiler(60);
                System.out.println("9-10. Pile pleine : " + pile.estPleine());

                // Étape 11 : Empiler dans pile pleine (doit lever exception)
                pile.empiler(70);

            } catch (IllegalStateException e) {
                System.out.println("11. Exception attrapée : pile pleine");
            } catch (Exception e) {
                System.out.println("Erreur générale : " + e.getMessage());
            }
        }

    /**
     * Vérifie que la pile argument est vide. Un message affiche le résultat
     * du test
     * @param p  pile supposée être vide
     * @param nomPile  nom de la pile testée
     */
    private static void testCreationPileVide(PileEntier p, String nomPile){
        if (p.estVide()) {
            System.out.println("Création avec succès de la pile " + nomPile + " (vide) !"
                    + " Elle contient : " + p);
        } else {
            System.out.println("Test NOK pour la création "
                    + "de la pile " + nomPile);
        }
    }

    /**
     * Test que les capacités des piles sont correctes
     * @param p             pile supposée avec la même capacité que identique
     * @param identique     pile supposée avec la même capacité que p
     * @param differente    pile avec une capactité différente des précédentes
     */
    private static void testCapacite(PileEntier p, PileEntier identique, PileEntier differente) {

        if (PileEntier.memeCapacite(p, identique)
                && !PileEntier.memeCapacite(p, differente)
                && !PileEntier.memeCapacite(identique, differente)) {
            System.out.println("Test OK pour la méthode memeCapacite.");
        } else {
            System.out.println("Test NOK pour la méthode memeCapacite.");
        }
    }

    /**
     * Test de la méthode equals
     * @param p             pile supposée identique à identique
     * @param identique     pile supposée identique à  p
     * @param differente    pile supposée différente de p et identique
     */
    private static void testEgalite(PileEntier p, PileEntier identique, PileEntier differente) {

        if (p.equals(identique) && !p.equals(differente)  && !p.equals(differente)) {
            System.out.println("Test OK pour la méthode equals.");
        } else {
            System.out.println("Test NOK pour la méthode equals.");
        }
    }


    /**
     * Test des méthodes de la classe Pile. Dans ce test, aucune exception
     * ne doit se produire. Cette assertion est également vérifiée par le test.
     */
    private static void testSansException() {

        // ETAPE 1 : Test des méthodes sans provoquer d'exception
        System.out.println("ETAPE de TEST numéro 1 :\n"
                + "    Test des méthodes de la classe Pile\n"
                + "    et vérification qu'aucune exception ne "
                + "se produit\n\n");

        /*
         * aucune exception ne doit se produire dans le code ci-dessous
         * sauf si l'utilisateur entre trop d'éléments pour la pile p
         */
        try {
            PileEntier p = new PileEntier(5);                    // pile de référence
            PileEntier inverse = new PileEntier(5);              // recevra l'inverse de p
            PileEntier grandePile = new PileEntier(10);          // pour le test sur la capacité

            // on vérifie que les 3 piles sont vides,
            System.out.println("  ===> Tests création des piles");
            testCreationPileVide(p, "p");
            testCreationPileVide(inverse, "inverse");
            testCreationPileVide(grandePile, "grandePile");

            // on teste la méthode de comparaison des capacités, et equals
            System.out.println("\n\n  ===> Tests sur les piles vides");
            testCapacite(p, inverse, grandePile);
            testEgalite(p, inverse, grandePile);

            // on empile les entiers de 1 à 5 dans la pile p
            for (int n = 1; n <= 5; n++) {
                p.empiler(n);
            }
            System.out.println("\n\n  ===> Tests sur des piles non vides\n");
            System.out.println("La pile p contient-elle les entiers de 1 à 5 ?\n"
                    + p + "       => "
                    + (p.toString().equals(
                    "[ sommet =  5 | 4 | 3 | 2 | 1 |  ]")
                    ? "OK " : "NOK") + "\n");

            // on dépile les éléments de p pour les empiler dans inverse
            while (!p.estVide()) {
                inverse.empiler(p.sommet());
                p.depiler();
            }
            System.out.println("Contenu de la pile inverse de la précédente "
                    + inverse + "    =>  "
                    + (inverse.toString().equals
                    ("[ sommet =  1 | 2 | 3 | 4 | 5 |  ]")
                    ? "OK " : "NOK") + "\n"
                    + "\net de la pile initiale (devenue vide) : "
                    + p + "   => " + (p.estVide() ? "OK" : "NOK"));

            // nouveau test pour equals
            System.out.println("\n\n  ===> Tests égalité");
            System.out.println("Test " + (! inverse.equals(p) ? "OK " : "NOK")
                    + " pour equals");


            // autres tests pour l'égalité
            inverse.depiler();
            inverse.depiler();      // inverse contient : sommet = 3, 4, 5
            p.empiler(5);
            p.empiler(4);           // p contient : sommet = 4, 5
            System.out.println("Test " + (! inverse.equals(p) ? "OK " : "NOK")
                    + " pour equals");
            p.empiler(3);          // p contient : sommet = 3, 4, 5
            System.out.println("Test " + (inverse.equals(p) ? "OK " : "NOK")
                    + " pour equals");

        } catch (IllegalArgumentException e) {
            System.out.println("Test NOK => Erreur inattendue : IllegalArgumentException");
        } catch (IllegalStateException e) {
            System.out.println("Test NOK => Erreur inattendue : IllegalStateException");
        }
    }


    /**
     * Test des méthodes de la classe Pile. Dans ce test, on vérifie que les
     * exceptions attendues sont bien propagées par les méthodes de la classe PileEntier
     */
    private static void testDesExceptions() {
        int testOk = 0;                     // nombre de tests corrects

        // ETAPE 2 : Test des exceptions
        System.out.println("\n\nETAPE de TEST numéro 2\n"
                + "    Vérification que les exceptions sont levées\n");

        // l'exception IllegalArgumentException sera levée  (constructeur)
        try {
            PileEntier p = new PileEntier(-5);
            System.out.println("Test NOK pour capacité invalide");
        } catch (IllegalArgumentException e) {
            System.out.println("Test OK => Exception levée: IllegalArgumentException");
            testOk++;
        } catch (IllegalStateException e) {
            System.out.println("Test NOK => Erreur inattendue : IllegalStateException");
        }

        // l'exception IllegalStateException sera levée (méthode empiler)
        try {
            PileEntier p = new PileEntier(5);
            for (int i = 1; i <= 6 ; i++) {
                p.empiler(i);
            }
            System.out.println("Test NOK pour empiler (ErreurPilePleine)");
        } catch (IllegalArgumentException e) {
            System.out.println("Test NOK => Erreur inattendue : IllegalArgumentException");
        } catch (IllegalStateException e) {
            System.out.println("Test OK => Exception levée: : IllegalStateException");
            testOk++;
        }

        // l'exception IllegalStateException sera levée (méthode depiler)
        try {
            PileEntier p = new PileEntier(5);
            p.depiler();
            System.out.println("Test NOK pour depiler (ErreurPileVide)");
        } catch (IllegalArgumentException e) {
            System.out.println("Test NOK => Erreur inattendue : IllegalArgumentException");
        } catch (IllegalStateException e) {
            System.out.println("Test OK => Exception levée: : IllegalStateException");
            testOk++;
        }

        // l'exception IllegalStateException sera levée (méthode sommet)
        try {
            PileEntier p = new PileEntier(5);
            System.out.println(p.sommet());
            System.out.println("Test NOK pour sommet (ErreurPileVide)");
        } catch (IllegalArgumentException e) {
            System.out.println("Test NOK => Erreur inattendue : IllegalArgumentException");
        } catch (IllegalStateException e) {
            System.out.println("Test OK => Exception levée: : IllegalStateException");
            testOk++;
        }

        // résultat global du test
        if (testOk == 4) {
            System.out.println("\nTous les tests sur les exceptions ont réussi.");
        } else {
            System.out.println("\nAu moins un test sur les exceptions a échoué.");
        }
    }

    /**
     * Fonction principale pour lancer les tests
     * @param args paramètre non utilisé
     */
    public static void main(String[] args) {

        testSimpleDuSujet();
        // test des méthodes sans lever les exceptions
        testSansException();

        // test de la propagation correcte des exceptions
        testDesExceptions();
    }
}
