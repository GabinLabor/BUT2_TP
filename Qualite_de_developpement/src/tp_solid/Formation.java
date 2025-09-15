/**
 * @author PPC - IUT Rodez
 * @version 2025
 */
package tp_solid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */
public class Formation {
	
	private String parcours;
	private int annee;
	
	
	/**
	 * @param parcours Parcours (parmi "INFO", "GEA", "QLIO", "INFOCOM")
	 * @param annee Année
	 */
	public Formation(String parcours, int annee) {
		super();
		this.parcours = parcours;
		this.annee = annee;
	}



	/**
	 * Obtenir le parcours de la formation
	 * @return Le parcours
	 */
	public String getParcours() {
		return parcours;
	}



	/**
	 * Modifier le parcours de la formation
	 * @param parcours Le nouveau parcours (parmi "INFO", "GEA", "QLIO", "INFOCOM")
	 */
	public void setParcours(String parcours) {
		this.parcours = parcours;
	}



	/**
	 * Obtenir l'année de la formation
	 * @return l'année
	 */
	public int getAnnee() {
		return annee;
	}

	
	
	/**
	 * Modifier l'année
	 * @param annee la nouvelle annee
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}



	/**
	 * Obtenir le nom du parcours
	 * @return Nom du parcours
	 */
	public String getNom() {
		String nom;
		switch (this.parcours) {
			case "INFO" :
				nom = "Informatique";
				break;
			case "GEA":
				nom = "Gestion des Entreprises et des Administrations";
				break;
			case "QLIO":
				nom = "Qualité, Logistique Industrielle et Organisation";
				break;
            case "INFOCOM":
                nom = "Information et communication";
                break;
			default:
				throw new IllegalArgumentException("Parcours ne peut pas être '" + parcours + "'");
		}		
		return nom;
	}
	
	
	
	/**
	 * Obtenir les compétences du parcours
	 * @return Liste des compétences
	 * @throws IllegalArgumentException
	 */
	public List<String> getCompetences() throws IllegalArgumentException {
		List<String> competences;
		switch (this.parcours) {
			case "INFO" :
				competences = new ArrayList<String>(Arrays.asList(
						"Réaliser un développement d’application",
						"Optimiser des applications informatiques",
						"Administrer des systèmes informatiques communicants complexes",
						"Gérer des données de l’information",
						"Conduire un projet",
						"Travailler dans une équipe informatique"
						));
				break;
			case "GEA":
				competences = new ArrayList<String>(Arrays.asList(
						"Analyser les processus de l’organisation dans son environnement",
						"Décider : aider à la prise de décision",
						"Piloter les relations avec les parties prenantes de l’organisation"
						));
				break;
			case "QLIO":
				competences = new ArrayList<String>(Arrays.asList(
						"Piloter l’entreprise par la qualité",
						"Organiser des activités de production de biens ou de services",
						"Gérer les flux physiques et les flux d’information"
						));
				break;
            case "INFOCOM":
                competences = new ArrayList<String>(Arrays.asList(
                        "Analyser les pratiques et les enjeux liés à l’information et à la communication au niveau local, national et international",
                        "Partager : informer et communiquer au sein des organisations",
                        "Concevoir une stratégie communication"
                ));
                break;
			default:
				throw new IllegalArgumentException("Parcours ne peut pas être '" + parcours + "'");
		}
		return competences;
	}
	

}
