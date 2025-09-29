/**
 * @author PPC - IUT Rodez
 * @version 2025
 */

package tp_solid.document.compterendu;

import tp_solid.document.DocumentStandard;

public class Soutenance extends AbstractCompteRenduAvecDiapo {

	/**
	 - Crée une nouvelle Soutenance
	 * @param diaporama
	 * @param texte
	 */
	public Soutenance(DocumentStandard diaporama, DocumentStandard texte) {
		super(diaporama, texte);
	}
	
}
