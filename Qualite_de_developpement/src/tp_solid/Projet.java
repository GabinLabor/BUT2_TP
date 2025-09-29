/**
 * @author PPC - IUT Rodez
 * @version 2025
 */
package tp_solid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tp_solid.document.Document;
import tp_solid.document.WritableDocument;
import tp_solid.document.compterendu.CompteRendu;
import tp_solid.document.export.Export;

/**
 * Projet étudiant
 */
public class Projet {
	
	private String nom;
	private List<Document> documents;
	private List<CompteRendu> compteRendus;
	private List<Etudiant> etudiants;
	private Export export;

	/**
	 - Crée un nouveau projet
	 * @param nom Nom du projet
	 */
	public Projet(String nom, Export export) {
		super();
		this.nom = nom;
		this.documents = new ArrayList<Document>();	
		this.compteRendus = new ArrayList<CompteRendu>();	
		this.etudiants = new ArrayList<Etudiant>();	
		this.export = export;
	}

	
	
	/**
	 * Obtenir le nom du projet
	 * @return Nom du projet
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Modifier le nom du projet
	 * @param nom Nom du projet
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Obtenir la liste des documents du projet
	 * @return Liste des documents
	 */
	public List<Document> getDocuments() {
		return documents;
	}

	/**
	 * Ajouter un document au projet
	 * @param document Nouveau document
	 */
	public void addDocument(Document document) {
		this.documents.add(document);
	}

	/**
	 * Enlever un document du projet
	 * @param document Document à enlever
	 * @return Vrai ssi le document était présent
	 */
	public boolean removeDocument(Document document) {
		return this.documents.remove(document);
	}

	/**
	 * Obtenir la liste des compte-rendus
	 * @return Liste des compte-rendus
	 */
	public List<CompteRendu> getCompteRendus() {
		return compteRendus;
	}

	/**
	 * Ajouter un compte-rendu au projet
	 * @param compteRendu Nouveau compte-rendu
	 */
	public void addCompteRendu(CompteRendu compteRendu) {
		this.compteRendus.add(compteRendu);
	}

	/**
	 * Enlever un compte-rendu
	 * @param compteRendu Compte-rendu à enlever
	 * @return Vrai ssi le compte-rendu était présent
	 */
	public boolean removeCompteRendu(CompteRendu compteRendu) {
		return this.compteRendus.remove(compteRendu);
	}

	/**
	 * Obtenir la liste des étudiants participant au projet
	 * @return Liste des étudiants
	 */
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	/**
	 * Ajouter un étudiant au projet
	 * @param etudiant Nouvel étudiant
	 */
	public void addEtudiant(Etudiant etudiant) {
		etudiant.addProjet(this);
		this.etudiants.add(etudiant);
	}

	/**
	 * Enlever un étudiant du projet
	 * @param etudiant Etudiant à enlever
	 * @return Vrai ssi l'étudiant participait au projet
	 */
	public boolean removeEtudiant(Etudiant etudiant) {
		etudiant.removeProjet(this);
		return this.etudiants.remove(etudiant);
	}
	
	
	
	/**
	 * Ouvrir tous les documents du projet
	 * @throws IOException 
	 */
	public void openAllDocs() throws IOException {
		for (Document doc: documents) {
			doc.open();
			System.out.println("Ouverture : " + doc.getFilename()+ "\n\t" + new String(doc.getRawData()));
		}
	}
	
	/**
	 * Enregistrer tous les documents du projet
	 * @throws IOException 
	 */
	public void saveAllDocs() throws IOException {
		for (Document doc: documents) {
			if (doc instanceof WritableDocument) {
				((WritableDocument) doc).save();
				System.out.println("Enregistrement : " + doc.getFilename());
			}
		}
	}
	
	/**
	 * Exporter tous les documents dans un fichier
	 * @param filename Fichier d'export
	 * @throws IOException 
	 */
	public void exporterDocuments(String filename) throws IOException {
		this.export.exporter(this.documents, filename);
	}
	
	
}
