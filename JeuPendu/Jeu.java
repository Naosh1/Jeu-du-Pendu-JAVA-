import java.util.Scanner;
import java.util.Set;

public class Jeu {

    public static void JeuEnCours(int essaisRestants, boolean motTrouvé, String motCaché, String mot, String pseudo) {
        Scanner sc = new Scanner(System.in);
        Set<String> lettresUtilisées = Mots.initialiserLettresUtilisées();

        while (essaisRestants > 0 && !motTrouvé) {
            System.out.println("Mot à deviner : " + motCaché);
            System.out.println("Choisissez une lettre : ");
            String lettre = sc.nextLine();

            if (lettre.length() != 1 || !Character.isLetter(lettre.charAt(0))) {
                System.out.println("Veuillez entrer une seule lettre !");
                continue;
            }

            String nouveauMotCaché = Mots.lettreTrouvé(lettre.toLowerCase(), motCaché, mot, lettresUtilisées);

            if (nouveauMotCaché.equals(motCaché)) {
                essaisRestants--;
                System.out.println("Il vous reste " + essaisRestants + " essais.");
            } else {
                motCaché = nouveauMotCaché;
                System.out.println("Mot à deviner : " + motCaché);
            }

            if (motCaché.equals(mot)) {
                System.out.println("Félicitations " + pseudo + ", tu as trouvé le mot : " + mot + " !");
                rejouer(pseudo);
                motTrouvé = true;
                break;
            }

            System.out.println("As-tu une idée du mot ? o/n :");
            String choix = sc.nextLine().toLowerCase();

            while (!choix.equals("o") && !choix.equals("n")) {
                System.out.println("Réponse invalide. Veuillez répondre par 'o' ou 'n' :");
                choix = sc.nextLine().toLowerCase();
            }

            if (choix.equals("o")) {
                System.out.println("Entre le mot : ");
                String ideeMot = sc.nextLine();

                if (ideeMot.equals(mot)) {
                    System.out.println("Félicitations " + pseudo + ", tu as trouvé le mot : " + mot + " !");
                    rejouer(pseudo);
                    motTrouvé = true;
                    break;
                } else {
                    System.out.println("Bien essayé ! Mais ce n'est pas le bon mot.");
                }
            } else if (choix.equals("n")) {
                System.out.println("Très bien, le jeu va reprendre !");
            }

            essaisRestants--;
        }

        if (!motTrouvé) {
            System.out.println("Dommage " + pseudo + ", tu as perdu. Le mot était : " + mot);
            rejouer(pseudo);
        }
    }

    public static void JeuLancer() {
        Scanner sc = new Scanner(System.in);
        int essaisRestants = 8;
        boolean motTrouvé = false;
        String mot = Mots.choixMotsAléatoire();
        String motCaché = Mots.afficherMotCaché(mot);

        System.out.println("Votre pseudo ? (en 12 caractères max) ");
        String pseudo = sc.nextLine();
        if (pseudo.length() > 12) {
            pseudo = pseudo.substring(0, 12);
        }
        System.out.println("Bienvenue à toi " + pseudo + " !");
        JeuEnCours(essaisRestants, motTrouvé, motCaché, mot, pseudo);
    }

    private static void relancement(String pseudo) {
        Scanner sc = new Scanner(System.in);
        int essaisRestants = 8;
        boolean motTrouvé = false;
        String mot = Mots.choixMotsAléatoire();
        String motCaché = Mots.afficherMotCaché(mot);
        System.out.println("La partie va se relancer " + pseudo + " !");
        System.out.println("Lancement de la partie..");
        JeuEnCours(essaisRestants, motTrouvé, motCaché, mot, pseudo);
    }

    public static boolean rejouer(String pseudo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Voulez-vous rejouer ? o/n : ");
        String decision = sc.nextLine();

        while (!decision.equals("o") && !decision.equals("n")) {
            System.out.println("Voulez-vous rejouer ? o/n : ");
            decision = sc.nextLine();
        }
        if (decision.equals("o")) {
            relancement(pseudo);
        }
        else if(decision.equals("n")) {
            System.out.println("Merci d'avoir joué !");
        }
        return true;
    }
}
