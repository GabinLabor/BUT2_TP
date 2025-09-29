/**
 * @author Pierre Pomeret-Coquot - IUT de Rodez
 - @version 2025
 */
package tp_solid.document.export;

import java.io.IOException;
import java.util.List;

import tp_solid.document.Document;
import tp_solid.document.DocumentStandard;

/**
 * Exporation du document en mode 'txt'
 */
public class ExportTXT implements Export {
	
	private String encoding = "UTF-8";
	
	
	/**
	 * Obtenir l'encodage de caractères
	 * @return L'encodage
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * Modifier l'encodage de caractères
	 * @param encoding Le nouvel encodage
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	@Override
	public void exporter(List<Document> documents, String filename) throws IOException {
		DocumentStandard docExport = new DocumentStandard(filename, "txt");
		String contenu = "";
		for (Document doc : documents) {
			doc.open();
			contenu = contenu +  "--------------------\nDocument '" + doc.getFilename() + "\n--------------------\n" + new String(doc.getRawData()) + "\n--------------------\n\n\n";
		}
		docExport.setRawData(contenu.getBytes());
		docExport.save();
	}
}
