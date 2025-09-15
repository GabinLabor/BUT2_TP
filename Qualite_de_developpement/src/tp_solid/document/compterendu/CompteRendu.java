/**
 * @author PPC - IUT Rodez
 * @version 2025
 */

package tp_solid.document.compterendu;

import tp_solid.document.Document;

public interface CompteRendu {
	
	/**
	 * obtenir le texte associé au compte-rendu
	 * @return Le texte
	 */
	Document getTexte();
	
	/**
	 * Obtenir le diaporama associé au compte-rendu
	 * @return Le diaporama
	 */
	Document getDiaporama();

}
