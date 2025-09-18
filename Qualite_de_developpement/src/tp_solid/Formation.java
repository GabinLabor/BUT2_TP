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
public abstract class Formation {
	
	private int annee;
	
	/**
	 * @param annee Année
	 */
	public Formation( int annee) {
		super();
		this.annee = annee;
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
	 *
	 */
	public abstract String getNom();

	/**
	 * Obtenir les compétences du parcours
	 */
	public abstract List<String> getCompetences() throws IllegalArgumentException;
}
