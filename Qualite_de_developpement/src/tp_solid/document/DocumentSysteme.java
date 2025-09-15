/**
 * @author PPC - IUT Rodez
 * @version 2025
 */

package tp_solid.document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DocumentSysteme extends Document {
	
	private String os;

	public DocumentSysteme(String filename, String type, String os) {
		super(filename, type);
		this.os = os;
	}

	/**
	 * Enregistre une copie du fichier sous filename+'.tmp'
	 */
	@Override
	public void save() throws IOException {
		String alternative_filename = filename + ".tmp";
		Files.write(Paths.get(alternative_filename), rawData);
		System.err.println("Warning: Les documents systèmes sont en lecture "
				+ "seule, une copie du document a été enregistrée sous '"
				+ alternative_filename + "'.");
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
