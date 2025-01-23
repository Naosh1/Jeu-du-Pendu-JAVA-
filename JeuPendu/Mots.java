import java.util.HashSet;
import java.util.Set;
import java.util.Random;

class Mots {
    private static final String[] MOTS = {
            "ordinateur", "programmation", "clavier", "souris", "ecran",
            "fenetre", "table", "chaise", "voiture", "maison",
            "ecole", "soleil", "nuage", "pluie", "arbre",
            "fleur", "livre", "crayon", "papier", "musique",
            "chanson", "guitare", "piano", "foret", "montagne",
            "riviere", "mer", "plage", "chateau", "ciel",
            "oiseaux", "etoile", "lune", "saison", "hiver",
            "printemps", "automne", "animaux", "poisson",
            "chien", "chat", "lapin", "grenouille", "eclair",
            "orage", "amie", "famille", "joie", "bonheur",
            "travail", "vacances"
    };

    public static String choixMotsAléatoire() {
        Random random = new Random();
        return MOTS[random.nextInt(MOTS.length)];
    }

    public static String afficherMotCaché(String mot) {
        while (mot == null || mot.length() < 2) {
            mot = Mots.choixMotsAléatoire();
        }
        char premiereLettre = mot.charAt(0);
        char derniereLettre = mot.charAt(mot.length() - 1);
        StringBuilder masque = new StringBuilder();
        masque.append(premiereLettre);

        for (int i = 1; i < mot.length() - 1; i++) {
            masque.append("_");
        }
        masque.append(derniereLettre);
        return masque.toString();
    }

    public static String lettreTrouvé(String lettre, String motCaché, String mot, Set<String> lettresUtilisées) {
        if (lettresUtilisées.contains(lettre)) {
            System.out.println("Cette lettre a déjà été utilisée.");
            return motCaché;
        }

        lettresUtilisées.add(lettre);
        StringBuilder motCachéModifié = new StringBuilder(motCaché);
        boolean lettreTrouvée = false;

        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) == lettre.charAt(0)) {
                motCachéModifié.setCharAt(i, lettre.charAt(0));
                lettreTrouvée = true;
            }
        }

        if (lettreTrouvée) {
            System.out.println("Bien joué, tu as trouvé une lettre !");
        } else {
            System.out.println("Dommage, la lettre n'est pas dans le mot.");
        }

        return motCachéModifié.toString();
    }

    public static Set<String> initialiserLettresUtilisées() {

        return new HashSet<>();
    }
}
