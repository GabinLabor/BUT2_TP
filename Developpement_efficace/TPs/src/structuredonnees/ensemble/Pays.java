/*
 * Classe Pays
 * Pays.java                            09/25
 */
package structuredonnees.ensemble;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Représentation d'un pays avec son nom et l'ensemble de ses pays limitrophes.
 * Les pays limitrophes sont stockés dans un TreeSet pour éviter les doublons.
 * @author Gabin Laborieux
 * @version 1.0
 */
public class Pays {

    /**
     * Nom du pays
     */
    private final String nom;

    /**
     * Ensemble des pays limitrophes (noms)
     */
    private final TreeSet<String> voisins;

    /**
     * Crée un pays avec son nom. L'ensemble des voisins est initialisé à vide.
     *
     * @param nom nom du pays
     * @throws IllegalArgumentException si le nom est invalide
     */
    public Pays(String nom) {
        verifierNom(nom);
        this.nom = nom.trim();
        this.voisins = new TreeSet<>();
    }

    /**
     * Crée un pays avec son nom et un tableau de noms de pays limitrophes.
     * @param nom       nom du pays
     * @param voisins   tableau des noms des pays voisins (peut être vide)
     * @throws IllegalArgumentException si le nom du pays ou d'un voisin est
     *                                  invalide
     */
    public Pays(String nom, String[] voisins) {
        verifierNom(nom);

        this.nom = nom.trim();
        this.voisins = new TreeSet<>();

        if (voisins != null) {
            for (String v : voisins) {
                verifierNom(v);
                this.voisins.add(v.trim());
            }
        }
    }

    /**
     * Vérifie qu'un nom de pays est valide (non nul et non vide avec blank).
     *
     * @param nom nom à vérifier
     * @throws IllegalArgumentException si le nom est invalide
     */
    private static void verifierNom(String nom) {
        if (nom.isBlank()) {
            throw new IllegalArgumentException("Nom de pays invalide");
        }
    }

    /**
     * Ajoute un pays voisin. Si le pays est déjà présent, l'opération est
     * sans effet.
     * @param voisin nom du pays voisin à ajouter
     * @throws IllegalArgumentException si le nom est invalide
     */
    public void ajouterVoisin(String voisin) {
        verifierNom(voisin);
        this.voisins.add(voisin.trim());
    }

    /**
     * Indique si la liste passée correspond exactement à l'ensemble des
     * voisins du pays courant (ordre et doublons ignorés).
     * @param paysListe liste des noms de pays à comparer
     * @return true si égalité ensembliste, false sinon
     */
    public boolean aPourVoisin(ArrayList<String> paysListe) {
        if (paysListe == null) {
            return false;
        }
        TreeSet<String> nettoyes = new TreeSet<>();
        for (String p : paysListe) {
            if (p == null || p.isBlank()) {
                return false;
            }
            nettoyes.add(p.strip());
        }
        return this.voisins.equals(nettoyes);
    }

    /* Précédente version
     * Indique si le pays passé en argument est limitrophe du pays courant.
     * @param pays nom du pays à tester
     * @return true si présent dans l'ensemble des voisins, false sinon
     *
    public boolean aPourVoisin(String pays) {
        if (pays.isBlank()) {
            return false;
        }
        return this.voisins.contains(pays.trim());
    } */

    public int nombreVoisin() {
        return this.voisins.size();
    }

    /**
     * Chaîne pour décrire le pays courant : son nom et la liste de ses voisins.
     * Exemple : XX a pour voisin : [Italie, Allemagne, Luxembourg ...]
     * @return description textuelle du pays
     */
    @Override
    public String toString() {
        return nom + " a pour voisin : " + voisins;
    }

}
