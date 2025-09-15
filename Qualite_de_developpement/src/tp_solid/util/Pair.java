/**
 * @author PPC - IUT Rodez
 * @version 2025
 */

package tp_solid.util;


/**
 * Paire d'éléments (l,r)
 * @param <L> Type du premier élément (left)
 * @param <R> Type du second élément (right)
 */
public class Pair<L,R> {
	
	private L l;
	private R r;
	
	/**
	 - Crée une nouvelle paire
	 * @param l Premier élément (left)
	 * @param r Second élément (right)
	 */
	public Pair(L l, R r) {
		this.l = l;
		this.r = r;
	}

	/**
	 * Obtenir le premier élément (left)
	 * @return Premier élément
	 */
	public L getL() {
		return l;
	}

	/**
	 * Modifier le premier élément (left)
	 * @param l Nouveau premier élément
	 */
	public void setL(L l) {
		this.l = l;
	}

	/**
	 * Obtenir le deuxième élément (right)
	 * @return Deuxième élément
	 */
	public R getR() {
		return r;
	}

	/**
	 * Modifier le deuxième élément (right)
	 * @param r Nouveal deuxième élément
	 */
	public void setR(R r) {
		this.r = r;
	}

}
