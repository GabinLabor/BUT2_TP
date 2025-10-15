package hex.main;

import hex.controller.Gestionnaire;

public class Lanceur {
    public static void main(String[] args) {
        Gestionnaire g = Gestionnaire.getInstance();
        g.nouvellePartie(5); // exemple taille 5x5
        g.jouer();
    }
}
