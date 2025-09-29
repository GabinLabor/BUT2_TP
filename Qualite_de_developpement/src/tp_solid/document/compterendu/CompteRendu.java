/**
 * @author PPC - IUT Rodez
 * @version 2025
 */

package tp_solid.document.compterendu;

import java.util.List;

import tp_solid.document.DocumentStandard;

public interface CompteRendu {
	
	/**
	 * obtenir le texte associé au compte-rendu
	 * @return Le texte
	 */
	DocumentStandard getTexte();
	
	/**
	 * Obtenir tous les documents associés au compte-rendu (p.ex. texte, diaporama, etc.)
	 * @return Liste des documents
	 */
	List<DocumentStandard> getAllDocuments();

}
