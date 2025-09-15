/**
 * @author PPC - IUT Rodez
 * @version 2025
 */
package tp_solid;

import tp_solid.document.Document;

public class Main2 {

    public static void main(String[] args) {


        // Chargement des données fictives
        Etudiant etu = MkDonneesFictives.getDonnees();
        etu.setFormation(new Formation("INFOCOM", 2025));


        // Afficher le nom et le numero étudiant
        System.out.println(etu.getNom() + " (" + etu.getNumeroEtu() + ")");
        System.out.println();


        // Question 1. Affichage de la formation de l'étudiant
        Formation formation = etu.getFormation();
        System.out.println("Formation : " + formation.getNom() + " (" + formation.getAnnee() + ")");
        for (String comp : formation.getCompetences()) {
            System.out.println("+ " + comp);
        }
        System.out.println();

        System.out.println(">> Question 1 OK\n\n");


        // Question 2. Affichage du planing de l'étudiant
        // Décommenter ci-dessous
		/*
		etu.afficherPlanning("xml");
		System.out.println();
		*/
		/*
		etu.afficherPlanning("xml", "americain");
		System.out.println();

		System.out.println(">> Question 2 OK\n\n");
		*/


        // Question 3. Quelques tests
        /*
         * Pour utiliser "assert", il faut activer les assertions dans la VM.
         * Run > Run configurations > Arguments > VM arguments > -ea ou -enableassertions
         * (Sinon, vous pouvez utiliser JUnit ou, à défaut, faire manuellement in if...then)
         */
        // Décommenter ci-dessous
		/*
		Projet projet1 = etu.getProjets().get(0);
		String signature = " + SIGNATURE";

		// Vérifier que la ligne suivante produit une AssertionError avant de la supprimer
		assert(false);

		try {
			for (Document doc : projet1.getDocuments()) {
				doc.open();
				System.out.println("Contenu du document : " + new String(doc.getRawData()));
				assert(!estSigne(doc, signature));
			}
			System.out.println(">> Question 3 - Spec 1 OK");

			for (Document doc : projet1.getDocuments()) {
				// ...
			}
			System.out.println(">> Question 3 - Spec 2 OK");

			for (Document doc : projet1.getDocuments()) {
				// ...
			}
			System.out.println(">> Question 3 - Spec 3 OK");

			for (Document doc : projet1.getDocuments()) {
				// ...
			}
			System.out.println(">> Question 3 - Spec 4 OK");
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/




        // Question 4. Export en mode XML des comptes-rendus
        // Décommenter ci-dessous
		/*
		try {
			projet1.exporterComptesRendus("documents.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/

        // Question 5. Export en mode TXT des documents
        // Décommenter ci-dessous
		/*
		Export export = new ExportTXT();
		System.out.println("Export en TXT (encoding=" + export.getEncoding() + ")");
		try {
			projet1.exporterDocuments("documents.txt", export);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Export en mode TXT des comptes-rendus
		System.out.println("Export en TXT (encoding=" + export.getEncoding() + ")");
		try {
			projet1.exporterComptesRendus("comptes-rendus.txt", export);
		} catch (IOException e) {
			e.printStackTrace();
		}
	*/



    }

    public static void signerDocument(Document document, String signature) {
        String contenu = new String(document.getRawData()) + signature;
        document.setRawData(contenu.getBytes());
    }

    public static boolean estSigne(Document document, String signature) {
        String contenu = new String(document.getRawData());
        return contenu.endsWith(signature);
    }

}
