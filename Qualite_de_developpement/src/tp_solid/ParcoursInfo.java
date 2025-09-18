package tp_solid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParcoursInfo {

    public ParcoursInfo(int annee) {
        super(annee); // appelle le constructeur
    }

    @Override
    public String getNom() {
        return "Informatique";
    }

    @Override
    public List<String> getCompetences() throws IllegalArgumentException {
        return new ArrayList<String>(Arrays.asList(
                "Java",
                "C++",
                "C#",
                "PHP",
                "HTML",
                "JavaScript",
                "SQL"
        ));
    }
}
