package hex.ihm;

import hex.PartieHex;
import hex.PlateauHex;
import hex.Coords;

public interface IHM {
    void actualiserPlateau(PlateauHex plateau);
    void afficherInfos(PartieHex partie);
    Coords demanderPlacement(PlateauHex plateau);
}
