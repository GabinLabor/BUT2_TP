/**
 * @author PPC - IUT Rodez
 * @version 2025
 */

package tp_solid.document.compterendu;

import tp_solid.document.Document;
import java.util.List;

public interface CompteRendu {
	
	/**
	 * obtenir le texte associé au compte-rendu
	 * @return Le texte
	 */
	Document getTexte();

    /**
     * @return Liste de tous les documents disponibles (p. ex texte, diapo, etc.)
     */
    List<Document> getAllDocs();

}
