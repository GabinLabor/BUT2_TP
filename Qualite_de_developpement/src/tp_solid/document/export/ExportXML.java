/**
 * @author Pierre Pomeret-Coquot - IUT de Rodez
 - @version 2025
 */
package tp_solid.document.export;

import java.io.IOException;
import java.util.List;

import tp_solid.document.Document;

/**
 * Exportation de documents en mode 'xml'
 */
public class ExportXML {
	
	private String encoding = "UTF-8";
	private String xmlVersion = "1.0";
	
	/**
	 * Obtenir l'encodage de caractères
	 * @return l'encodage
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * Modifier l'encodage de caractères
	 * @param encoding le nouvel encodage
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * Obtenir la version d'XML utilisée
	 * @return la version XML
	 */
	public String getXmlVersion() {
		return xmlVersion;
	}

	/**
	 * Modifier la version d'XML utilisée
	 * @param xmlVersion la nouvelle version
	 */
	public void setXmlVersion(String xmlVersion) {
		this.xmlVersion = xmlVersion;
	}

	
	

	/**
	 * Exporte un ensemble de documents en mode XML
	 * @param documents documents à exporter
	 * filename Fichier d'export
	 * @throws IOException 
	 */
	public void exporter(List<Document> documents, String filename) throws IOException {
		Document docExport = new Document(filename, "txt");
		String contenu = "<?xml version=\"" + xmlVersion + "\" encoding=\"" + encoding + "\"?>\n<documents>\n";
		for (Document doc : documents) {
			doc.open();
			contenu = contenu +  "\t<document>\n\t\t<filename>" + doc.getFilename() + "</filename>\n\t\t<type>" + doc.getType() + "</type>\n\t\t<contenu>" + new String(doc.getRawData()) + "</contenu>\n\t</document>\n";
		}
		contenu = contenu + "</documents>";
		docExport.setRawData(contenu.getBytes());
		docExport.save();
	}

}
