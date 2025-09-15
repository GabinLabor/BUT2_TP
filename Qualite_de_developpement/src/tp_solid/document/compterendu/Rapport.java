/**
 * @author PPC - IUT Rodez
 * @version 2025
 */

package tp_solid.document.compterendu;

import tp_solid.document.Document;

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
	public Document getDiaporama() {		
		throw new UnsupportedOperationException("Les rapports n'ont pas de diaporama");
	}

}
