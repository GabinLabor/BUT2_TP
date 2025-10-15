package hex.controller;

import hex.PartieHex;
import hex.ihm.IHM;
import hex.ihm.IHMConsole;

public class Gestionnaire implements GestionnaireDePartie {
    private static Gestionnaire instance = null;
    private PartieHex partie;
    private final IHM ihm = new IHMConsole();

    // Constructeur privé pour le pattern Singleton
    private Gestionnaire() {}

    // Méthode pour obtenir l'instance unique
    public static Gestionnaire getInstance() {
        if (instance == null) {
            instance = new Gestionnaire();
        }
        return instance;
    }

    @Override
    public void nouvellePartie(int taillePlateau) {
        partie = new PartieHex(taillePlateau);
    }

    @Override
    public void jouer() {
        // Boucle principale du jeu
        while (!partie.estFini()) {  // ✅ corrigé : méthode s'appelle estFini(), pas estFinie()
            ihm.actualiserPlateau(partie.getPlateau());
            ihm.afficherInfos(partie);

            var coup = ihm.demanderPlacement(partie.getPlateau());
            try {
                partie.poserJeton(coup); // ✅ correspond à la méthode de PartieHex
            } catch (Exception e) {
                System.out.println("Coup invalide : " + e.getMessage());
            }
        }

        // Partie terminée : affichage final
        ihm.actualiserPlateau(partie.getPlateau());
        ihm.afficherInfos(partie);
    }
}
