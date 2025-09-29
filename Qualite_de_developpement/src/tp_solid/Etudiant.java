/**
 * @author PPC - IUT Rodez
 * @version 2025
 */
package tp_solid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tp_solid.formation.Formation;
import tp_solid.util.Pair;




public class Etudiant {

	private String nom;
	private int numeroEtu;
	private Formation formation;
	private List<Projet> projets;
	private List<Pair<Date,Projet>> joursTravailles;




	/**
	 * @param numeroEtu Numéro étudiant
	 * @param nom Nom de l'étudiant
	 * @param formation Formation de l'étudiant
	 */
	public Etudiant(int numeroEtu, String nom, Formation formation) {
		super();
		this.numeroEtu = numeroEtu;
		this.nom = nom;
		this.formation = formation;
		this.projets = new ArrayList<Projet>();
		this.joursTravailles = new ArrayList<Pair<Date,Projet>>();
	}




	/**
	 * Obtenir le nom
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}




	/**
	 * Modifier le nom
	 * @param nom le nouveau nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}




	/**
	 * Obtenir le numeroEtu
	 * @return le numeroEtu
	 */
	public int getNumeroEtu() {
		return numeroEtu;
	}




	/**
	 * Modifier le numeroEtu
	 * @param numeroEtu le nouveau numeroEtu
	 */
	public void setNumeroEtu(int numeroEtu) {
		this.numeroEtu = numeroEtu;
	}




	/**
	 * Obtenir la formation
	 * @return la formation
	 */
	public Formation getFormation() {
		return formation;
	}




	/**
	 * Modifier la formation
	 * @param formation la nouvelle formation
	 */
	public void setFormation(Formation formation) {
		this.formation = formation;
	}




	/**
	 * Obtenir la liste des projets
	 * @return la liste des projets
	 */
	public List<Projet> getProjets() {
		return projets;
	}




	/**
	 * Obtenir le planning de l'étudiant
	 * @return le planning
	 */
	public List<Pair<Date, Projet>> getJoursTravailles() {
		return joursTravailles;
	}




	/**
	 * Ajouter un nouveau projet
	 * @param projet nouveau projet
	 */
	public void addProjet(Projet projet) {
		this.projets.add(projet);
	}

	/**
	 * Supprimer un projet
	 * @param projet Projet à supprimer
	 * @return Vrai ssi le projet était présent avant suppression
	 */
	public boolean removeProjet(Projet projet) {
		return this.projets.remove(projet);
	}





	/**
	 * Ajouter un jour travaillé
	 * @param jour Jour à ajouter
	 * @param projet Le projet travaillé ce jour
	 */
	public void addJourTravaille(Date jour, Projet projet) {
		this.joursTravailles.add(new Pair<Date, Projet>(jour, projet));
	}




}
