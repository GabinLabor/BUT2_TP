/**
 * Document.java
 * @author PPC - IUT Rodez
 * @version 2025
 */
package tp_solid.document;

import java.io.IOException;

/**
 * 
 */
public interface Document {

	/**
	 * Obtenir le nom du fichier
	 * @return le nom de fichier
	 */
	public String getFilename();

	/**
	 * Modifier le nom du fichier
	 * @param filename Nouveau nom de fichier
	 */
	public void setFilename(String filename);

	/**
	 * Obtenir le contenu du fichier
	 * @return Donénes brutes
	 */
	public byte[] getRawData();
	
	/**
	 * Modifier le contenu du fichier
	 * @param data Nouvelles données
	 */
	public void setRawData(byte[] data);
	
	/**
	 * Obtenir le type du fichier
	 * @return Type du fichier
	 */
	public String getType();
	
	/**
	 * Modifier le type du fichier
	 * @param type Nouveau type
	 */
	public void setType(String type);
	
	/**
	 * Lire les donénes brutes depuis le fichier. Ecrase les données brutes (rawData) actuellement en mémoire.
	 * @throws IOException
	 */
	public void open() throws IOException;
	
	/**
	 * Enregistre une copie du document sous filename
	 * @param filename Chemin du fichier à créer / écraser
	 * @throws IOException
	 */
	public void copy(String filename) throws IOException;

}
