import java.util.Scanner;

class Menu {
    public static void menuChoix() {
        Scanner sc = new Scanner(System.in);
        int choixMenu;
        System.out.println("  ======================================    ");
        System.out.println("  ||  BIENVENUE DANS LE JEU DU PENDU  ||     ");
        System.out.println("  ======================================    ");

        do {
            // Menu avec des options stylées
            System.out.println("\n============ MENU PRINCIPAL ============");
            System.out.println("     1. 💥 Démarrer une Nouvelle Partie   ");
            System.out.println("     2. 📖 Voir les Règles du Jeu         ");
            System.out.println("     3. ❌ Quitter le Jeu                 ");
            System.out.println("       Choisissez une option (1-3) :      ");
            System.out.println("========================================  ");
            choixMenu = sc.nextInt();
            sc.nextLine();
        } while (choixMenu < 1 || choixMenu > 3);
        switch (choixMenu) {
            case 1:
                System.out.println("\n💡 Lancement d'une nouvelle partie...");
                String pseudo = joueur.pseudo();
                String mot = Mots.choixMotsAléatoire();
                String motCaché = Mots.afficherMotCaché(mot);
                int essaisRestants = 8;
                boolean motTrouvé = false;
                Jeu.JeuEnCours(8, motTrouvé, motCaché, mot, pseudo);
                break;

            case 2:
                afficherRegles();
                break;

            case 3:
                System.out.println("Merci d'avoir joué ! À bientôt.");
                break;

            default:
                System.out.println("⚠️ Choix invalide, veuillez entrer un numéro entre 1 et 3.");
                break;
        }
    }

    public static void afficherRegles() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n                     ===📜 RÈGLES DU JEU ===                                  ");
        System.out.println("1. Vous devez deviner un mot, lettre par lettre.                                ");
        System.out.println("2. Chaque fois que vous proposez une lettre incorrecte, vous perdez un essai.   ");
        System.out.println("3. Vous avez un total de 8 essais avant de perdre.                              ");
        System.out.println("4. Si vous trouvez le mot avant de perdre tous vos essais, vous gagnez !        ");
        System.out.println("5. Si vous perdez tous vos essais, c'est la fin de la partie.                   ");
        System.out.println("          =============================================                    ");
        System.out.println("          ||  🎯 Bonne chance et amusez-vous bien !  ||                    ");
        System.out.println("          =============================================                    ");

        System.out.println("Voulez-vous retourner au menu ? o/n : ");
        String backMenu = sc.nextLine();
        do {
            if (!backMenu.equals("o") && !backMenu.equals("n")) {
                System.out.println("⚠️ Saisie incorrecte, seulement o ou n ! ⚠️");
                System.out.println("Voulez-vous retourner au menu ? o/n : ");
                backMenu = sc.nextLine();
            }
        } while (!backMenu.equals("o") && !backMenu.equals("n"));

        if (backMenu.equals("o")) {
            menuChoix();
        } else {
            System.out.println("Merci d'avoir lu les règles ! À bientôt !");
        }
    }
}
