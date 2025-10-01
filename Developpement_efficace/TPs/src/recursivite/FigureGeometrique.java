package recursivite;

public class FigureGeometrique {
    public static void blanc(int n) {
        if (n > 0) {
            System.out.print(' ');
            blanc(n - 1);
        }
    }

    // récursive pour afficher une ligne de n étoiles séparées par un espace
    private static void afficherLigne(int n) {
        if (n > 0) {
            afficherLigne(n - 1);
            System.out.print("* ");
        } else if (n == 0) {
            System.out.println();
        }
    }

    public static void afficherTriangle(int n) {
        if (n > 0) {
            afficherTriangle(n - 1);
            afficherLigne(n);
        }
    }

    public static void main(String[] args) {
        afficherLigne(15);
        System.out.println();
        System.out.println();
        afficherTriangle(4);
    }
}

