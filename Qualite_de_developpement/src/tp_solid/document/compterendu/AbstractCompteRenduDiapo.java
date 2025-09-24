package tp_solid.document.compterendu;

import tp_solid.document.Document;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCompteRenduDiapo implements CompteRenduDiapo{

    @Override
    public List<Document> getAllDocs() {
        List<Document> l = new ArrayList<>();
        l.add(this.getTexte());
        l.add(this.getDiaporama());
        return l;
    }
}
