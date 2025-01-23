import java.util.Scanner;

public class joueur {
    private static String lettresDejaUtilisees = "";

    public static String pseudo() {
        String pseudo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Votre pseudo ? (en 12 caractères max) ");
        pseudo = sc.nextLine();

        while (pseudo.length() > 12 || pseudo.length() == 0) {
            System.out.println("Votre pseudo ? (en 12 caractères max) ");
            pseudo = sc.nextLine();
        }
        System.out.println("Bienvenue à toi " + pseudo + " !");
        return pseudo;
    }

    public static String lettreChoix() {
        String lettre;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Entrez une lettre : ");
            lettre = sc.nextLine();

            if (lettresDejaUtilisees.contains(lettre)) {
                System.out.println("Cette lettre a déjà été utilisée. Veuillez en choisir une autre.");
            }
        } while (lettre.length() > 1 || lettre.length() == 0 || lettresDejaUtilisees.contains(lettre));

        lettresDejaUtilisees += lettre;

        return lettre;
    }

    public static String getLettresDejaUtilisees() {
        return lettresDejaUtilisees;
    }

}
