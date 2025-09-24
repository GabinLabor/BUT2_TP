/**
 * @author PPC - IUT Rodez
 * @version 2025
 */

package tp_solid.document.compterendu;

import tp_solid.document.Document;

import java.util.ArrayList;

public class Rapport implements CompteRendu {
	
	private Document texte;

	public Rapport(Document texte) {
		super();
		this.texte = texte;
	}

	@Override
	public Document getTexte() {
		return texte;
	}
	
	public void setTexte(Document texte) {
        this.texte = texte;
	}

    @Override
    public List<Document> getAllDocs() {
        List<Document> l = new ArrayList<>();
        l.add(this.getTexte());
        return 1;
    }

}
