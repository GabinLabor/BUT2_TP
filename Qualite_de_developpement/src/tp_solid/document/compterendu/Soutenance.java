/**
 * @author PPC - IUT Rodez
 * @version 2025
 */

package tp_solid.document.compterendu;

import tp_solid.document.Document;

import java.util.ArrayList;
import java.util.List;

public class Soutenance extends AbstractCompteRenduDiapo {
	
	private Document diaporama;
	private Document texte;
	
	

	public Soutenance(Document diaporama, Document texte) {
		super();
		this.diaporama = diaporama;
		this.texte = texte;
	}


	@Override
	public Document getTexte() {
		return texte;
	}
	
	
	public void setDiaporama(Document diaporama) {
		this.diaporama = diaporama;
	}


	@Override
	public Document getDiaporama() {
		return diaporama;
	}


	public void setTexte(Document texte) {
		this.texte = texte;
	}


}
