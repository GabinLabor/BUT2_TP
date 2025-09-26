package tp_solid.document.affplanning;

import tp_solid.Etudiant;
imort tp_solid Projet;
import tp_solid.Projet;
import tp_solid.util.Pair;

import java.text.DateFormat;

public class AfficheurPLanningTXT implements AfficheurPlanning{

    private DateFormat dateFormat;

    public AfficheurPLanningXML(DateFormat dateformat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public void afficher(Etudiant etu) {
        String nomFormation = etu.getFormation().getNom();

        String xml = "<planning>";
        xml =
        System.out.println("Planning de " + etu.getNom() + " (" + nomFormation + ")");
        System.out.println(" --------------");
        for (Pair<Date,Projet> pair : etu.getJoursTravailles()) {
            Date date = pair.getL();
            Projet projet = pair.getR();
            System.out.println("+ " + projet.getNom);
        }
    }
}
