package heritage;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test complet de la classe Personne avec validation email ===\n");
        
        // 1. Test des constructeurs avec emails valides et invalides
        System.out.println("1. Test de validation email dans les constructeurs :\n");
        
        // Email valide
        Personne personne1 = new Personne("Dupont", "Jean", "0123456789", "jean.dupont@email.fr");
        System.out.println("--- Personne avec email valide ---");
        personne1.afficher();
        System.out.println();
        
        // Email invalide (sera remplacé par défaut)
        Personne personne2 = new Personne("Martin", "Marie", "0987654321", "email_invalide");
        System.out.println("--- Personne avec email invalide (remplacé par défaut) ---");
        personne2.afficher();
        System.out.println();
        
        // Email vide (sera remplacé par défaut)
        Personne personne3 = new Personne("Durand", "Pierre", "0555666777", "");
        System.out.println("--- Personne avec email vide (remplacé par défaut) ---");
        personne3.afficher();
        System.out.println();
        
        // 2. Test de différents formats d'emails valides
        System.out.println("2. Test de différents formats d'emails valides :\n");
        
        Personne[] personnesTest = {
            new Personne("Test1", "User", "0111111111", "user@domain.com"),
            new Personne("Test2", "User", "0222222222", "user.name@site.fr"),
            new Personne("Test3", "User", "0333333333", "user_123@test-site.org"),
            new Personne("Test4", "User", "0444444444", "contact@example.co")
        };
        
        for (int i = 0; i < personnesTest.length; i++) {
            System.out.println("Test " + (i+1) + " :");
            System.out.println("Email : " + personnesTest[i].information().split("\n")[2]);
            System.out.println();
        }
        
        // 3. Test de formats d'emails invalides
        System.out.println("3. Test de formats d'emails invalides (remplacés par défaut) :\n");
        
        String[] emailsInvalides = {
            "user@", // pas de domaine
            "@domain.com", // pas de partie locale
            "user@domain", // pas d'extension
            "user@domain.toolong", // extension trop longue
            "user spaces@domain.com", // espaces
            "user@domain..com", // double point
            "user@@domain.com", // double @
            "user@domain.c" // extension trop courte
        };
        
        for (int i = 0; i < emailsInvalides.length; i++) {
            Personne p = new Personne("Test", "Invalid" + (i+1), "0123456789", emailsInvalides[i]);
            System.out.println("Email testé : '" + emailsInvalides[i] + "' -> Résultat : " + 
                             p.information().split("\n")[2]);
        }
        System.out.println();
        
        // 4. Test interactif de saisie avec validation
        System.out.println("4. Test interactif de saisie avec validation email :\n");
        System.out.println("Vous allez pouvoir tester la saisie avec validation.");
        System.out.println("Essayez d'abord un email invalide, puis un valide.\n");
        
        Personne personneInteractive = new Personne();
        personneInteractive.saisir();
        
        System.out.println("\n--- Personne après saisie interactive ---");
        personneInteractive.afficher();
        System.out.println();
        
        // 5. Test de la méthode information()
        System.out.println("5. Test de la méthode information() :\n");
        
        System.out.println("Information personne avec email valide :");
        System.out.println(personne1.information());
        System.out.println();
        
        System.out.println("Information personne avec email par défaut :");
        System.out.println(personne2.information());
        System.out.println();

        // 6. Test d'affichage nom/prénom seulement
        System.out.println("6. Test d'affichage nom et prénom uniquement :\n");
        System.out.println("Personne 1 : " + personne1);
        System.out.println("Personne 2 : " + personne2);
        System.out.println("Personne 3 : " + personne3);
        System.out.println();
        
        System.out.println("=== Tests terminés - Validation email fonctionnelle ===");
    }
}