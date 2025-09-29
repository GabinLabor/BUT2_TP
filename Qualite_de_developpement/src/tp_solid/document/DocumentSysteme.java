/**
 * @author PPC - IUT Rodez
 * @version 2025
 */

package tp_solid.document;

public class DocumentSysteme extends AbstractDocument {
	
	private String os;

	public DocumentSysteme(String filename, String type, String os) {
		super(filename, type);
		this.os = os;
	}

	/**
	 * Obtenir le système d'exploitation associé
	 * @return Système d'exploitation
	 */
	public String getOs() {
		return os;
	}

	/**
	 * Modifier le système d'exploitation associé
	 * @param os Nouveau système d'exploitation
	 */
	public void setOs(String os) {
		this.os = os;
	}
	
	
}
