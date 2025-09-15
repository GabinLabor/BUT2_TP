/**
 * @author PPC - IUT Rodez
 * @version 2025
 */
package tp_solid;

import java.io.IOException;

import tp_solid.document.compterendu.CompteRendu;
import tp_solid.document.compterendu.Soutenance;

/**
 * Démonstration de l'application actuelle
 */
public class Main {

	public static void main(String[] args) {
		
		
		// Chargement des données fictives
		Etudiant etu = MkDonneesFictives.getDonnees();
		
		
		// Afficher le nom et le numero étudiant
		System.out.println(etu.getNom() + " (numéro étudiant = " + etu.getNumeroEtu() + ")");
		System.out.println();
		
		
		// Affichage de la formation de l'étudiant
		Formation formation = etu.getFormation();
		System.out.println("Formation : " + formation.getNom() + " (" + formation.getAnnee() + ")");
		for (String comp : formation.getCompetences()) {
			System.out.println("+ " + comp);
		}
		System.out.println();
		
		
		// Affichage du planing de l'étudiant
		etu.afficherPlanning();
		System.out.println();
		
		
		// Affichage les projets de l'étudiant
		System.out.println("Projets :");
		for (Projet projet : etu.getProjets()) {
			System.out.println("+ " + projet.getNom());
		}
		System.out.println();
		
		
		// Ouverture et affichage des documents du projet 1
		Projet projet1 = etu.getProjets().get(0);
		try {
			projet1.openAllDocs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		
		
		// Enregistrement des documents du projet 1
		try {
			projet1.saveAllDocs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		
		
		
		// Ouverture et affichage des textes et diaporamas des comptes rendus
		for (CompteRendu cptRendu : projet1.getCompteRendus()) {
			try {
				cptRendu.getTexte().open();
				System.out.println("Compte-rendu '" + cptRendu.getTexte().getFilename() + "' (type = " + cptRendu.getTexte().getType() + ")");
				System.out.println("\t" + new String(cptRendu.getTexte().getRawData()));
				if (cptRendu instanceof Soutenance) {
					cptRendu.getDiaporama().open();
					System.out.println("Compte-rendu '" + cptRendu.getDiaporama().getFilename() + "' (type = " + cptRendu.getDiaporama().getType() + ")");
					System.out.println("\t" + new String(cptRendu.getDiaporama().getRawData()));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println();
		
		
		// Export en mode XML des documents
		System.out.println("Export en XML (version=" + projet1.getExportXmlVersion() + ", encoding=" + projet1.getExportEncoding() + ")");
		try {
			projet1.exporterDocuments("documents.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		System.out.println("Démo terminée");
	}

}
