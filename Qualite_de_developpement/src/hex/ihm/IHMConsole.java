package hex.ihm;

import hex.affich.AffichagePlateau;
import hex.affich.AffichageInformationsDuTour;
import hex.PartieHex;
import hex.PlateauHex;
import hex.Coords;

import java.util.Scanner;

public class IHMConsole implements IHM {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void actualiserPlateau(PlateauHex plateau) {
        // Affichage du plateau à l’aide de la méthode statique du jar
        System.out.println(AffichagePlateau.plateau2string(plateau));
    }

    @Override
    public void afficherInfos(PartieHex partie) {
        // Affichage des infos de tour à l’aide du jar
        System.out.println(AffichageInformationsDuTour.getStringInfo(partie));
    }

    @Override
    public Coords demanderPlacement(PlateauHex plateau) {
        while (true) {
            try {
                System.out.print("Entrez la ligne (0 à " + (plateau.getTaillePlateau() - 1) + ") : ");
                int x = sc.nextInt();
                sc.nextLine(); // Consomme le retour à la ligne

                System.out.print("Entrez la colonne (A, B, C, ...) : ");
                String colStr = sc.nextLine().trim().toUpperCase();

                // Vérifie que la saisie est valide (une seule lettre)
                if (colStr.length() != 1 || colStr.charAt(0) < 'A' ||
                        colStr.charAt(0) >= 'A' + plateau.getTaillePlateau()) {
                    System.out.println("⚠️  Colonne invalide. Essayez encore.");
                    continue;
                }

                int y = colStr.charAt(0) - 'A'; // Convertit A→0, B→1, C→2, etc.
                return new Coords(x, y);

            } catch (Exception e) {
                System.out.println("⚠️  Entrée invalide. Veuillez recommencer.");
                sc.nextLine(); // vide le buffer pour éviter une boucle infinie
            }
        }
    }
}
