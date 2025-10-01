/*
 * Gabin Laborieux
 */

package recursivite;

public class OutilEntierRecursif {
    /**
     * Calcul le n-ième terme de la suite de Fibonacci de façon récursive
     *
     * @param n l'indice du terme à calculer
     * @return la valeur du n-ième terme de la suite de Fibonacci
     * @throws IllegalArgumentException si n < 0
     */
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n ne doit pas être négatif");
        }

        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;  // U1 = 1
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        // pour tester jusqu'à n = 10
        for (int i = 0; i <= 10; i++) {
            System.out.println("U" + i + " = " + fibonacci(i));
        }
    }
}
